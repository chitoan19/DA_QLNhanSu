import { TaiKhoanService } from './../../service/tai-khoan.service';
import { NotificationsService } from 'angular2-notifications';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { TaiKhoan } from 'src/app/model/tai-khoan';

@Component({
  selector: 'app-tai-khoan-detail',
  templateUrl: './tai-khoan-detail.component.html',
  styleUrls: ['./tai-khoan-detail.component.css']
})
export class TaiKhoanDetailComponent implements OnInit {
  quyen: string;
  trang_thai: string;
  tk: TaiKhoan;
  isEdit = false;
  isEditQuyen = false; // check if user logined can edit?
  user: TaiKhoan;//user logined
  constructor(private router: Router, private notificationService: NotificationsService,
    private route: ActivatedRoute, private tkService: TaiKhoanService) {
    this.tk = new TaiKhoan();
    this.user = JSON.parse(localStorage.getItem('currentUser'));

  }

  ngOnInit(): void {

    this.tk.id = this.route.snapshot.params['id'];
    this.tkService.getNhanVien(this.tk).subscribe(data => {
      this.tk = data.object;
      this.quyen = (this.tk.quyen == 0)?'user':((this.tk.quyen == 1)?'admin':'super admin');
      this.trang_thai = (this.tk.trang_thai == 1)?'Active':'Inactive';
      if(this.user.quyen > this.tk.quyen){
        this.isEditQuyen = true;
      }
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
