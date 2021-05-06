import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NotificationsService } from 'angular2-notifications';
import { TaiKhoan } from '../model/tai-khoan';
import { TaiKhoanService } from '../service/tai-khoan.service';

@Component({
  selector: 'app-my-acount',
  templateUrl: './my-acount.component.html',
  styleUrls: ['./my-acount.component.css']
})
export class MyAcountComponent implements OnInit {
  quyen: string;
  trang_thai: string;
  tk: TaiKhoan;
  isEdit = false;

  constructor(private router: Router, private notificationService: NotificationsService,private route: ActivatedRoute, private tkService: TaiKhoanService) {
    this.tk = new TaiKhoan();
  }

  ngOnInit(): void {
    this.tk.id = this.route.snapshot.params['id'];
    this.tkService.getNhanVien(this.tk).subscribe(data => {
      this.tk = data.object;
      this.quyen = (this.tk.quyen == 0)?'User':((this.tk.quyen == 1)?'Admin':'Super Admin');
      this.trang_thai = (this.tk.trang_thai == 1)?'Active':'Inactive';
    });
  }

  public back(){
    this.router.navigate(['dashboard/tai-khoan']);
  }

  public notity(message){
    this.notificationService.success('success', message,{
      timeOut: 2000,
      position: ['bottom', 'right']
    });
  }

  public onSubmit(){
    this.tkService.update(this.tk).subscribe(data =>{
      this.tk = data.object;
      this.notity("Cập nhật thành công!");
      this.isEdit = !this.isEdit;
    });
  }

  public enableEdit(){
    this.isEdit = !this.isEdit;
  }

}
