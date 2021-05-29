import { NhanVienService } from './../../service/nhan-vien.service';
import { TaiKhoanService } from './../../service/tai-khoan.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { TaiKhoan } from 'src/app/model/tai-khoan';
import { NotificationsService } from 'angular2-notifications';
import { forkJoin } from 'rxjs';
import { Response } from 'src/app/response/response';
@Component({
  selector: 'app-tai-khoan-create',
  templateUrl: './tai-khoan-create.component.html',
  styleUrls: ['./tai-khoan-create.component.css']
})
export class TaiKhoanCreateComponent implements OnInit {
  tk = new TaiKhoan();
  listNv: any;
  listTK: any;
  newListNv = new Array();
  tkResponse = new Response<TaiKhoan>();
  user: TaiKhoan;
  constructor(private router: Router,private nvService: NhanVienService,
    private notificationService: NotificationsService, private tkService: TaiKhoanService) {
      this.user = new TaiKhoan();
      this.user = JSON.parse(localStorage.getItem('currentUser'));
   }

  ngOnInit(){
    const tk = this.tkService.getAllTaiKhoan();
    const nv = this.nvService.getAllNhanVien();
    forkJoin([tk,nv]).subscribe(results=>{
      this.listTK = results[0];
      this.listNv = results[1];

      this.listTK.forEach((item, index) => {
        this.listNv.forEach((item2, index2) => {
          if(item.nhan_vien_id == item2.id){
            this.listNv.splice(index2, 1);
          }
        });
      });
      this.newListNv = this.listNv;
      console.log(this.newListNv);
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
    this.tk.ngay_tao = new Date();
    this.tkService.create(this.tk).subscribe(data =>{
      this.tkResponse = data;
      if(this.tkResponse.result !== null){
        this.notity('Thêm thành công');
        this.back();
      }
    });
  }


}
