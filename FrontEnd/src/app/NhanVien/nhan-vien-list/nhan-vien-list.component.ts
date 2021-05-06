import { NhanVien } from './../../model/nhan-vien';
import { Router } from '@angular/router';
import { Response } from 'src/app/response/response';
import { ConfirmDialogComponent } from './../../confirm-dialog/confirm-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { NotificationsService } from 'angular2-notifications';
import { NhanVienRequest } from './../../request/nhan-vien-request';
import { Component, OnInit } from '@angular/core';
import { NhanVienService } from 'src/app/service/nhan-vien.service';

@Component({
  selector: 'app-nhan-vien-list',
  templateUrl: './nhan-vien-list.component.html',
  styleUrls: ['./nhan-vien-list.component.css']
})
export class NhanVienListComponent implements OnInit {
  nvRequest: NhanVienRequest;
  listNV: NhanVien[];
  nhanVien: NhanVien;
  nvResponse = new Response<NhanVien>();
  p: number;
  perPage: number;
  total: number;
  userId: number;
  constructor(private nvService: NhanVienService, private notificationService: NotificationsService, private dialog: MatDialog, private router: Router) {
    this.nvRequest = new NhanVienRequest();
    this.p = this.nvRequest.pageNum;
    this.userId = JSON.parse(localStorage.getItem('currentUser')).nhan_vien_id;
    this.nvRequest.id = this.userId;
  }

  ngOnInit(): void {

    this.getAll();
  }

  public detail(nv: NhanVien){
    this.router.navigate(['/dashboard/nhan-vien/detail/', nv.id]);
  }
  /**
   * name
   */
  public getAll() {
    this.nvRequest.id = this.userId;
    this.nvService.findAll(this.nvRequest).subscribe(data => {
      this.nvResponse = data;
      this.listNV = Array.from(this.nvResponse.list);
      this.perPage = this.nvRequest.pageSize;
      this.total = this.nvResponse.totalItem;
      console.log(this.listNV);
    });
  }

  /**
   * pageChanged
   */
  public pageChanged(event) {
    this.nvRequest.pageNum = event;
    console.log( this.nvRequest);
    this.getAll();
  }

  public refresh(){
    this.nvRequest = new NhanVienRequest();
    this.nvRequest.id = this.userId;
  }


  public openDialog(nv: NhanVien){

    let dialog = this.dialog.open(ConfirmDialogComponent);
    dialog.afterClosed().subscribe(data => {
      this.delete(nv, data);
    })
  }

  public delete(nv: NhanVien, isDel: String){
    if(isDel=="true"){
      this.nvService.delete(nv.id).subscribe(data => {
        console.log(data);
        this.getAll();
        this.notify('Xóa thành công');
      });
    }
  }

  public notify(notice){
    this.notificationService.success('success', notice, {
      timeOut: 2000,
      position: ['bottom', 'right']
    });
  }

  public filter(){
    this.nvRequest.id = this.userId;
    this.nvService.findAll(this.nvRequest).subscribe(data =>{
      this.listNV = data.list;
      this.total = data.totalItem;
      this.perPage = this.nvRequest.pageSize;
    });
  }
}
