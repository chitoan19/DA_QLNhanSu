import { NhanVienRequest } from './../request/nhan-vien-request';
import { NhanVienService } from 'src/app/service/nhan-vien.service';
import { Component, OnInit } from '@angular/core';
import { NhanVien } from '../model/nhan-vien';
import { forkJoin } from 'rxjs';

@Component({
  selector: 'app-trang-chu',
  templateUrl: './trang-chu.component.html',
  styleUrls: ['./trang-chu.component.css']
})
export class TrangChuComponent implements OnInit {
  nv: NhanVien;;
  nhan_vien_id: number;
  listNhanVienNu: NhanVien[];
  listNhanVienNam: NhanVien[];
  listNV: NhanVien[];
  totalNam: number;
  totalNu: number;
  totalNhanVien: number;
  panelOpenState = false;
  nvRequest: NhanVienRequest;
  constructor(private nvService: NhanVienService) {
    this.nvRequest = new NhanVienRequest();
    this.totalNhanVien = 0;
    this.nv = new NhanVien();
  }

  ngOnInit(): void {
    this.nhan_vien_id = JSON.parse(localStorage.getItem('currentUser')).nhan_vien_id;
    this.nvService.getNhanVienById(this.nhan_vien_id).subscribe(data=>{
      this.nv = data.object;
    });
    this.nvService.getAllNhanVien().subscribe(data =>{
      this.listNV = data;
    });
    this.getNamNu();
  }

  public getNamNu(){
    this.nvRequest.gioi_tinh = 1;
    this.nvService.findAll(this.nvRequest).subscribe(data => {
      this.listNhanVienNam = data.list;
      this.totalNam = data.totalItem;
      this.totalNhanVien += data.totalItem;

      this.nvRequest.gioi_tinh = 0;
      this.nvService.findAll(this.nvRequest).subscribe(data => {
        this.listNhanVienNu = data.list;
        this.totalNu = data.totalItem;
        this.totalNhanVien += data.totalItem;
      });
    });
  }

}
