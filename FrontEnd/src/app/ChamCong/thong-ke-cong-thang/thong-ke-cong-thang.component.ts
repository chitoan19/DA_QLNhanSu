import { NotificationsService } from 'angular2-notifications';
import { TaiKhoan } from 'src/app/model/tai-khoan';
import { element } from 'protractor';
import { LuongRequest } from './../../request/luong-request';
import { LuongServiceService } from './../../service/luong-service.service';
import { TinhLuongThang } from './../../model/tinh-luong-thang';
import { TinhLuongThangRequest } from './../../request/tinh-luong-thang-request';
import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NhanVien } from 'src/app/model/nhan-vien';
import { ChamCongRequest } from 'src/app/request/cham-cong-request';
import { ChamCongService } from 'src/app/service/cham-cong.service';
import { NhanVienService } from 'src/app/service/nhan-vien.service';
import { Luong } from 'src/app/model/luong';
import { Workbook } from 'exceljs';
import * as fs from 'file-saver';
@Component({
  selector: 'app-thong-ke-cong-thang',
  templateUrl: './thong-ke-cong-thang.component.html',
  styleUrls: ['./thong-ke-cong-thang.component.css']
})
export class ThongKeCongThangComponent implements OnInit {
  p: number;
  total: number;
  perPage: number;
  listNhanVien: NhanVien[];
  ccRequest: ChamCongRequest;
  TinhLuongThangRequest: TinhLuongThangRequest;
  errThang = false;
  errNV = false;
  listLuongThang: TinhLuongThang[];
  luongRequest: LuongRequest;
  objectNhanVien: Object;
  isLoad = false;
  userLogined: TaiKhoan;
  constructor(private ccService: ChamCongService, private nvService: NhanVienService,
    private modalService: NgbModal, private luongService: LuongServiceService,
    private notify: NotificationsService) {
      this.userLogined = JSON.parse(localStorage.getItem('currentUser'));
      this.ccRequest = new ChamCongRequest();
      this.luongRequest = new LuongRequest();
      this.p = this.ccRequest.pageNum;
      this.TinhLuongThangRequest = new TinhLuongThangRequest();
      this.perPage = this.TinhLuongThangRequest.pageSize;
      this.TinhLuongThangRequest = new TinhLuongThangRequest();
      this.ccRequest.nam = new Date().getFullYear();
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

  public changeSelect(event){
    this.TinhLuongThangRequest.nhan_vien_id = event.value;
    this.ccService.getThongKeCongThang(this.TinhLuongThangRequest).subscribe(data => {
      this.listLuongThang = data.list;
      this.total = data.totalItem;
    });
  }

  public submit(){
    this.ccService.getThongKeCongThang(this.ccRequest).subscribe(data => {
      this.listLuongThang = data.list;
      this.total = data.totalItem;
    });
  }

  public thongKeLuong(){
    if(!this.ccRequest.nam || !this.ccRequest.thang || this.ccRequest.thang < 0 || this.ccRequest.thang > 12){
      return;
    }
    this.isLoad = true;
    this.ccRequest.listIdnv = [];
    this.ccRequest.nguoi_cham = this.objectNhanVien[this.userLogined.id];
    Object.keys(this.objectNhanVien).forEach(item =>{
      this.ccRequest.listIdnv.push(parseInt(item));
    });
    console.log("ccRequest",this.ccRequest);
    this.ccService.thongKe(this.ccRequest).subscribe(data => {
      console.log("thong ke: ",data.list);
      if(data.list.length == 0){
        this.warn('Không có dữ liệu thống kê');
        this.isLoad = false;
        return;
      }
      setTimeout(()=>{
        this.isLoad = false;
        this.getData();
        this.modalService.dismissAll();
        this.alert('Thực hiện thành công');
      }, 1500);
    });
  }

  public openThongKeDialog(dialog){
    this.modalService.open(dialog, {
      backdrop: 'static'
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

  public refresh(){
    this.ccRequest = new ChamCongRequest();
    this.ccRequest.nam = new Date().getFullYear();
  }

  public getData(){
    this.ccService.getThongKeCongThang(this.TinhLuongThangRequest).subscribe(data => {
      this.listLuongThang = data.list;
      this.total = data.totalItem;
      this.perPage = this.TinhLuongThangRequest.pageSize || this.total;
    });
  }

  public changePageSize(e){
    this.TinhLuongThangRequest = new TinhLuongThangRequest();
    this.TinhLuongThangRequest.pageSize = e.target.value;

    this.getData();
  }

  public export(){
    console.log("list",this.listLuongThang);
    let workbook = new Workbook();
    let thang = new Date().getMonth() + 1;
    let nam = new Date().getFullYear();
    let worksheet = workbook.addWorksheet(`ThongKeLuongThang_${thang}_${nam}`);
    worksheet.columns = [
      {header: 'STT', key:'stt', width: 5, style: { font: { name: 'Roboto', size:10} }},
      {header: 'Nhân viên', key:'nv', width: 20, style: { font: { name: 'Roboto', size:10} }},
      {header: 'Thời gian', key:'thoiGian', width: 10, style: { font: { name: 'Roboto', size:10} }},
      {header: 'Số ngày công', key:'ngayCong', width: 15, style: { font: { name: 'Roboto', size:10} }},
      {header: 'Số buổi nghỉ', key:'buoiNghi', width: 15, style: { font: { name: 'Roboto', size:10} }},
      {header: 'Số buổi đi muộn', key:'diMuon', width: 15, style: { font: { name: 'Roboto', size:10} }},
      {header: 'Số giờ làm thêm', key:'lamThem', width: 15, style: { font: { name: 'Roboto', size:10} }},
      {header: 'Thưởng', key:'thuong', width: 10, style: { font: { name: 'Roboto', size:10} }},
      {header: 'Khấu trừ', key:'khauTru', width: 10, style: { font: { name: 'Roboto', size:10} }},
      {header: 'Tổng lương', key:'tongLuong', width: 15, style: { font: { name: 'Roboto', size:10} }},
    ];
    this.listLuongThang.forEach((item, index) => {
      let thoi_gian = `${item.thang}/${item.nam}`;
      worksheet.addRow({
        stt: index+1,
        nv: this.objectNhanVien[item.nhan_vien_id],
        thoiGian: thoi_gian,
        ngayCong: item.so_ngay_cong,
        buoiNghi: item.so_ngay_nghi_phep,
        diMuon: item.so_ngay_di_muon,
        lamThem: item.so_gio_lam_them,
        thuong: item.thuong,
        khauTru: item.khau_tru,
        tongLuong: this.formatMoney(item.tong_luong)
      }, 'n');
    });
    workbook.xlsx.writeBuffer().then((data) => {
      let blob = new Blob([data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
      fs.saveAs(blob, `ThongKeLuongThang_${thang}_${nam}`);
    })
  }

  public pageChanged(event) {
    this.TinhLuongThangRequest.pageNum = event;
    this.getData();
  }

  public alert(notice){
    this.notify.success('success', notice, {
      timeOut: 2000,
      position: ['bottom', 'right']
    });
  }

  public warn(notice){
    this.notify.warn('warn', notice, {
      timeOut: 2000,
      position: ['bottom', 'right']
    });
  }
}
