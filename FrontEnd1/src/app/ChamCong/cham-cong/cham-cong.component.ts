import { NhanVienService } from './../../service/nhan-vien.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { ChamCong } from 'src/app/model/cham-cong';
import { ChamCongRequest } from 'src/app/request/cham-cong-request';
import { ChamCongService } from 'src/app/service/cham-cong.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NotificationsService } from 'angular2-notifications';
import { NhanVien } from 'src/app/model/nhan-vien';

@Component({
  selector: 'app-cham-cong',
  templateUrl: './cham-cong.component.html',
  styleUrls: ['./cham-cong.component.css']
})
export class ChamCongComponent implements OnInit {
  p: number;
  perPage: number;
  total: number;
  listChamCong: ChamCong[];
  listNhanVien: NhanVien[];
  ccRequest: ChamCongRequest;
  importForm: FormGroup;
  file: any;
  now: number;
  objectNhanVien: Object;
  isLoad = false;
  constructor(private ccService: ChamCongService, private fb: FormBuilder, private nvService: NhanVienService,
    private modalService: NgbModal, private notificationService: NotificationsService) {
    this.ccRequest = new ChamCongRequest();
    this.ccRequest.nam = new Date().getFullYear();
    this.p = this.ccRequest.pageNum;
    this.perPage = this.ccRequest.pageSize;

  }

  ngOnInit(): void {
    this.nvService.getAllNhanVien().subscribe(data =>{
      this.listNhanVien = data;
      this.objectNhanVien = Array.from(this.listNhanVien).reduce((obj, item) =>{
          obj[item.id] = item.ho_ten;
          return obj;
      },{});
      this.now = new Date().getFullYear();
    });
    this.getData();
  }


  public openImportForm(importForm){
    this.modalService.open(importForm, {
      backdrop: 'static',
      size: 'lg'
    });
  }

  public submitImport(){
    this.isLoad = true;
    console.log("file",this.file);
    let data = new FormData();
    data.append("file", this.file);
    this.ccService.importFile(data).subscribe(data =>{
      this.isLoad = false;
      console.log("done", data);
      if(data.list){
        this.notify("Import thành công");
        this.modalService.dismissAll();
      }
    });
  }

  public getData(){
    this.ccService.findAllOf(this.ccRequest).subscribe(data =>{
      this.listChamCong = data.list;
      this.total = data.totalItem;
    });
  }

  public notify(notice){
    this.notificationService.success('success', notice, {
      timeOut: 2000,
      position: ['bottom', 'right']
    });
  }

  public onFileChanged(e){
    this.file = e.target.files[0];
  }

  public filter(){
    console.log(this.ccRequest);
    this.getData();
  }

  public detail(cc){

  }

  public refresh(){
    this.ccRequest = new ChamCongRequest();
    this.getData();
  }
  public pageChanged(event) {
    this.ccRequest.pageNum = event;
    this.getData();
  }
}
