import { NhanVienService } from './../../service/nhan-vien.service';
import { NotificationsService } from 'angular2-notifications';
import { MatDialog } from '@angular/material/dialog';
import { TaiKhoanService } from './../../service/tai-khoan.service';
import { TaiKhoan } from './../../model/tai-khoan';
import { AuthRequest } from './../../request/auth-request';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Response } from 'src/app/response/response';
import { ConfirmDialogComponent } from 'src/app/confirm-dialog/confirm-dialog.component';
import { NhanVien } from 'src/app/model/nhan-vien';

@Component({
  selector: 'app-tai-khoan-list',
  templateUrl: './tai-khoan-list.component.html',
  styleUrls: ['./tai-khoan-list.component.css']
})
export class TaiKhoanListComponent implements OnInit {
  authRequest: AuthRequest;
  listTK: TaiKhoan[];
  taiKhoan: TaiKhoan;
  tkResponse = new Response<TaiKhoan>();
  p: number;
  perPage: number;
  total: number;
  index: 0;
  objectNhanVien: Object;
  user: TaiKhoan;
  listNhanVien: NhanVien[];
  constructor(private tkService: TaiKhoanService, private dialog: MatDialog,
    private router: Router, private notificationService: NotificationsService,
    private nvService: NhanVienService) {
    this.authRequest = new AuthRequest();
    this.p = this.authRequest.pageNum;
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.authRequest.id = this.user.id;
  }

  ngOnInit(): void {
    this.nvService.getAllNhanVien().subscribe(data =>{
      this.listNhanVien = data;
      this.objectNhanVien = Array.from(this.listNhanVien).reduce((obj, item) =>{
          obj[item.id] = item.ho_ten;
          return obj;
      },{});
    });
    this.getAll();
  }

  public detail(tk: TaiKhoan){
    this.router.navigate(['/dashboard/tai-khoan/detail/', tk.id]);
  }
  /**
   * name
   */
  public getAll() {
    this.authRequest.id = this.user.id;
    this.tkService.findAll(this.authRequest).subscribe(data => {
      this.tkResponse = data;
      this.listTK = Array.from(this.tkResponse.list);
      this.perPage = this.authRequest.pageSize;
      this.total = this.tkResponse.totalItem;
      console.log(this.listTK);
    });
  }

  /**
   * pageChanged
   */
  public pageChanged(event) {
    this.authRequest.pageNum = event;
    this.getAll();
  }

  public refresh(){
    this.authRequest = new AuthRequest();
    this.authRequest.id = this.user.id;
  }


  public openDialog(tk: TaiKhoan){

    let dialog = this.dialog.open(ConfirmDialogComponent);
    dialog.afterClosed().subscribe(data => {
      this.delete(tk, data);
    })
  }

  public delete(tk: TaiKhoan, isDel: string){
    console.log(this.user.quyen, tk.quyen);
    if(this.user.quyen > tk.quyen){
      if(isDel == "true"){
        console.log(isDel);
        this.tkService.delete(tk.id).subscribe(data => {
          console.log(data);
          this.getAll();
          this.notify('Xóa thành công');
        });
      }
    } else {
      this.error('Bạn không được phép xóa tài khoản này');
    }
  }

  public error(err){
    this.notificationService.error('error', err, {
      timeOut: 2000,
      position: ['bottom', 'right']
    });
  }

  public notify(notice){
    this.notificationService.success('success', notice, {
      timeOut: 2000,
      position: ['bottom', 'right']
    });
  }

  public filter(){
    this.authRequest.id = this.user.id;
    this.tkService.findAll(this.authRequest).subscribe(data =>{
      this.listTK = data.list;
      this.total = data.totalItem;
      this.perPage = this.authRequest.pageSize;
    });
  }

}
