import { NhanVienService } from './../service/nhan-vien.service';
import { NhanVien } from 'src/app/model/nhan-vien';
import { LuongRequest } from './../request/luong-request';
import { NotificationsService } from 'angular2-notifications';
import { Component, OnInit } from '@angular/core';
import { LuongServiceService } from '../service/luong-service.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Luong } from '../model/luong';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-luong',
  templateUrl: './luong.component.html',
  styleUrls: ['./luong.component.css']
})
export class LuongComponent implements OnInit {
  p: number;
  perPage: number;
  total: number;
  luongRequest: LuongRequest;
  listLuong: Luong[];
  objectNhanVien: Object;
  listNhanVien: NhanVien[];
  editForm: FormGroup;
  idnvClicked: number;
  constructor(private luongService: LuongServiceService, private notificationService: NotificationsService,
    private modalService: NgbModal, private nvService: NhanVienService, private fb: FormBuilder) {
    this.luongRequest = new LuongRequest();
    this.p = this.luongRequest.pageNum;
    this.perPage = this.luongRequest.pageSize;
  }

  ngOnInit(): void {
    this.nvService.getAllNhanVien().subscribe(data =>{
      this.listNhanVien = data;
      this.objectNhanVien = Array.from(this.listNhanVien).reduce((obj, item) =>{
          obj[item.id] = item.ho_ten;
          return obj;
      },{});
      this.getData();
    });

  }

  public filter(event){
    this.luongRequest.nhan_vien_id = event.value;
    this.getData();

  }

  public detail(formDetail,item){
    this.idnvClicked = item.nhan_vien_id;
    this.editForm = this.fb.group({
      id: [''],
      luong_co_ban: [''],
      phu_cap: [''],
      muc_luong_lam_them_gio: [''],
      nhan_vien_id: ['']
    });
    this.editForm.patchValue({
      id: item.id,
      luong_co_ban: item.luong_co_ban,
      phu_cap: item.phu_cap,
      muc_luong_lam_them_gio: item.muc_luong_lam_them_gio,
      nhan_vien_id: item.nhan_vien_id
    });
    this.modalService.open(formDetail, {
      backdrop: 'static',
      size: 'lg'
    });
  }

  public submitEdit(){
    let luong = this.editForm.getRawValue();
    this.luongService.update(luong).subscribe(data => {
      this.luongRequest = new LuongRequest();
      this.getData();
      this.modalService.dismissAll();
    });
  }

  public formatMoney(number) {
    if (number) {
      if (!Number.isInteger(number)) {
        number = parseFloat(number).toFixed(2);
      }
      return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    } else {
      return 0;
    }
  }

  public getData(){
    this.luongService.findAll(this.luongRequest).subscribe(data =>{
      this.listLuong = data.list;
      this.total = data.totalItem;
    });
  }

  public pageChanged(event) {
    this.luongRequest.pageNum = event;
    this.getData();
  }

}
