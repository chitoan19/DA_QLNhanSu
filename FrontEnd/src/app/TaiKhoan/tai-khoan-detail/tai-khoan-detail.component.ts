import { NhanVienService } from './../../service/nhan-vien.service';
import { TaiKhoanService } from './../../service/tai-khoan.service';
import { NotificationsService } from 'angular2-notifications';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { TaiKhoan } from 'src/app/model/tai-khoan';
import { NhanVien } from 'src/app/model/nhan-vien';

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
  nhan_vien: NhanVien;
  constructor(private router: Router, private notificationService: NotificationsService,
    private route: ActivatedRoute, private tkService: TaiKhoanService, private nvService: NhanVienService) {
    this.tk = new TaiKhoan();
    this.nhan_vien = new NhanVien();
    this.user = JSON.parse(localStorage.getItem('currentUser'));

  }

  ngOnInit(): void {
    this.tk.id = this.route.snapshot.params['id'];
    this.tkService.getNhanVien(this.tk).subscribe(data => {
      this.tk = data.object;
      this.quyen = this.quyen = (this.tk.quyen == 0)?'User':((this.tk.quyen == 1)?'Admin':'Super Admin');
      this.trang_thai = (this.tk.trang_thai == 1)?'Active':'Inactive';
      if(this.user.quyen > this.tk.quyen){
        this.isEditQuyen = true;
      }
      this.nvService.getNhanVienById(this.tk.nhan_vien_id).subscribe(data => {
        this.nhan_vien = data.object;
      });
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
      this.trang_thai = (this.tk.trang_thai == 1)?'Active':'Inactive';
      this.quyen = this.quyen = (this.tk.quyen == 0)?'User':((this.tk.quyen == 1)?'Admin':'Super Admin');
      this.notity("Cập nhật thành công!");
      this.isEdit = !this.isEdit;
    });
  }

  public enableEdit(){
    this.isEdit = !this.isEdit;
  }

}
