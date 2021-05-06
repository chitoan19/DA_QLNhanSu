import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NotificationsService } from 'angular2-notifications';
import { BangCapChungChi } from 'src/app/model/bang-cap-chung-chi';
import { DanhGiaNhanVien } from 'src/app/model/danh-gia-nhan-vien';
import { NhanVien } from 'src/app/model/nhan-vien';
import { QuaTrinhCongTac } from 'src/app/model/qua-trinh-cong-tac';
import { QuaTrinhDaoTao } from 'src/app/model/qua-trinh-dao-tao';
import { ThongTinGiaDinh } from 'src/app/model/thong-tin-gia-dinh';
import { NhanVienService } from 'src/app/service/nhan-vien.service';

@Component({
  selector: 'app-personal-infor',
  templateUrl: './personal-infor.component.html',
  styleUrls: ['./personal-infor.component.css']
})
export class PersonalInforComponent implements OnInit {
  func : number;
  isEdit = false;
  isUpload = false;
  nv: NhanVien;
  thongTinGiaDinh: ThongTinGiaDinh[];
  bangCapChungChi: BangCapChungChi[];
  quaTrinhCongTac: QuaTrinhCongTac[];
  quaTrinhDaoTao: QuaTrinhDaoTao[];
  danhGiaNhanVien: DanhGiaNhanVien[];
  ttGiaDinh: ThongTinGiaDinh;
  gioitinh = "Nữ";
  title:string;
  ten_phong_ban: string;
  closeResult = '';
  editForm: FormGroup;
  createForm: FormGroup;
  avatar:any;
  selectedImg: string = null;
  constructor(private router: Router, private route: ActivatedRoute, private nvService: NhanVienService,
    private notificationService: NotificationsService, private modalService: NgbModal,
    private fb: FormBuilder) {
    this.nv = new NhanVien();
    this.func = 1;
    this.setTitle(this.func);
  }

  public onFileChanged(e){
    this.selectedImg = e.target.files[0];
    console.log(this.selectedImg);
  }

  public uploadAvatar(){
    let formData = new FormData();
    formData.append("img", this.selectedImg)
    this.nvService.uploadAvatar(formData, this.nv.id).subscribe(data=>{
      this.avatar = 'data:image/png;base64,' + data.object.anh;
      this.isUpload = !this.isUpload;
      this.notify("Cập nhật ảnh thành công");
    });
  }

  public openDetail(formDetail, item, i) {
    if(i == 2){
      this.editForm = this.fb.group({
        id: [''],
        ho_ten_nguoi_than: [''],
        quan_he: [''],
        tuoi: [''],
        nghe_nghiep: [''],
        noi_o_hien_nay: [''],
        noi_lam_viec: [''],
        nhan_vien_id: ['']
      });
      this.editForm.patchValue({
        id: item.id,
        ho_ten_nguoi_than: item.ho_ten_nguoi_than,
        quan_he: item.quan_he,
        tuoi: item.tuoi,
        nghe_nghiep: item.nghe_nghiep,
        noi_o_hien_nay: item.noi_o_hien_nay,
        noi_lam_viec: item.noi_lam_viec,
        nhan_vien_id: item.nhan_vien_id
      });
      console.log(this.editForm.getRawValue());
    }
    if(i == 3){
      this.editForm = this.fb.group({
        id: [''],
        ten_noi_dao_tao: [''],
        dia_chi: [''],
        trinh_do_dao_tao: [''],
        ngay_bat_dau: [''],
        ngay_ket_thuc: [''],
        nhan_vien_id: ['']
      });
      this.editForm.patchValue({
        id: item.id,
        ten_noi_dao_tao: item.ten_noi_dao_tao,
        dia_chi: item.dia_chi,
        trinh_do_dao_tao: item.trinh_do_dao_tao,
        ngay_bat_dau: item.ngay_bat_dau,
        ngay_ket_thuc: item.ngay_ket_thuc,
        nhan_vien_id: item.nhan_vien_id
      });
    }
    if(i == 4){
      this.editForm = this.fb.group({
        id: [''],
        ten_co_quan: [''],
        dia_chi_lam_viec: [''],
        ngay_bat_dau: [''],
        ngay_ket_thuc: [''],
        nhan_vien_id: ['']
      });
      this.editForm.patchValue({
        id: item.id,
        ten_co_quan: item.ten_co_quan,
        dia_chi_lam_viec: item.dia_chi_lam_viec,
        ngay_bat_dau: item.ngay_bat_dau,
        ngay_ket_thuc: item.ngay_ket_thuc,
        nhan_vien_id: item.nhan_vien_id
      });
    }
    if(i == 5){
      this.editForm = this.fb.group({
        id: [''],
        loai_bang: [''],
        ngay_cap: [''],
        nhan_vien_id: ['']
      });
      this.editForm.patchValue({
        id: item.id,
        loai_bang: item.loai_bang,
        ngay_cap: item.ngay_cap,
        nhan_vien_id: item.nhan_vien_id
      });
    }
    this.modalService.open(formDetail, {
      centered: true,
      backdrop: 'static',
      size: 'lg'
    });
  }

  public submitDetail(){
    var item = this.editForm.getRawValue();
    if(this.func == 2){
      this.nvService.saveThongTinGD(item, this.nv.id).subscribe(data =>{
        this.thongTinGiaDinh = data.list;
        this.modalService.dismissAll();
        this.notify("Cập nhật thành công");
      });
    }
    if(this.func == 3){
      this.nvService.saveQTDaoTao(item, this.nv.id).subscribe(data =>{
        this.quaTrinhDaoTao = data.list;
        this.modalService.dismissAll();
        this.notify("Cập nhật thành công");
      });
    }
    if(this.func == 4){
      this.nvService.saveQTCongTac(item, this.nv.id).subscribe(data =>{
        this.quaTrinhCongTac = data.list;
        this.modalService.dismissAll();
        this.notify("Cập nhật thành công");
      });
    }
    if(this.func == 5){
      this.nvService.saveBCCC(item, this.nv.id).subscribe(data =>{
        this.bangCapChungChi = data.list;
        this.modalService.dismissAll();
        this.notify("Cập nhật thành công");
      });
    }
  }
  public create(formCreate, i) {
    if(i == 2){
      this.createForm = this.fb.group({
        id: [''],
        ho_ten_nguoi_than: [''],
        quan_he: [''],
        tuoi: [''],
        nghe_nghiep: [''],
        noi_o_hien_nay: [''],
        noi_lam_viec: [''],
        nhan_vien_id: ['']
      });
    }
    if(i == 3){
      this.createForm = this.fb.group({
        id: [''],
        ten_noi_dao_tao: [''],
        dia_chi: [''],
        trinh_do_dao_tao: [''],
        ngay_bat_dau: [''],
        ngay_ket_thuc: [''],
        nhan_vien_id: ['']
      });

    }
    if(i == 4){
      this.createForm = this.fb.group({
        id: [''],
        ten_co_quan: [''],
        dia_chi_lam_viec: [''],
        ngay_bat_dau: [''],
        ngay_ket_thuc: [''],
        nhan_vien_id: ['']
      });

    }
    if(i == 5){
      this.createForm = this.fb.group({
        id: [''],
        loai_bang: [''],
        ngay_cap: [''],
        nhan_vien_id: ['']
      });

    }
    this.modalService.open(formCreate, {
      centered: true,
      backdrop: 'static',
      size: 'lg'
    });
  }
  public submitCreate(){
    var item = this.createForm.getRawValue();
    item.nhan_vien_id = this.nv.id;
    if(this.func == 2){
      this.nvService.addThongTinGD(item, this.nv.id).subscribe(data =>{
        this.thongTinGiaDinh = data.list;
        this.modalService.dismissAll();
        this.notify("Thêm thành công");
      });
    }
    if(this.func == 3){
      this.nvService.addQTDaoTao(item, this.nv.id).subscribe(data =>{
        this.quaTrinhDaoTao = data.list;
        this.modalService.dismissAll();
        this.notify("Thêm thành công");
      });
    }
    if(this.func == 4){
      this.nvService.addQTCongTac(item, this.nv.id).subscribe(data =>{
        this.quaTrinhCongTac = data.list;
        this.modalService.dismissAll();
        this.notify("Thêm thành công");
      });
    }
    if(this.func == 5){
      this.nvService.addBCCC(item, this.nv.id).subscribe(data =>{
        this.bangCapChungChi = data.list;
        this.modalService.dismissAll();
        this.notify("Thêm thành công");
      });
    }
  }

  ngOnInit(): void {
    this.nv.id = this.route.snapshot.params['id'];
    this.getData(this.nv.id);
  }

  public setGioiTinh(){
    if(this.nv.gioi_tinh == 1){
      this.gioitinh = "Nam";
    }else {
      this.gioitinh = "Nữ";
    }
  }

  public setTenPhongBan(){
    if(this.nv.phong_ban_id == 1){
      this.ten_phong_ban = "Giám đốc";
    }
    if(this.nv.phong_ban_id == 2){
      this.ten_phong_ban = "Phòng hành chính nhân sự";
    }
    if(this.nv.phong_ban_id == 3){
      this.ten_phong_ban = "Phòng hệ thống";
    }
    if(this.nv.phong_ban_id == 4){
      this.ten_phong_ban = "Phòng kinh doanh";
    }
    if(this.nv.phong_ban_id == 5){
      this.ten_phong_ban = "Phòng phát triển phần mềm";
    }
  }

  public back(){
    this.router.navigate(['/dashboard/nhan-vien']);
  }

  public onSubmit(func){
    if(func == 1){
      if(this.gioitinh === "Nam"){
        this.nv.gioi_tinh = 1;
      } else {
        this.nv.gioi_tinh = 0;
      }
      this.nvService.update(this.nv).subscribe(data =>{
      this.setTenPhongBan();
      this.setGioiTinh();
      this.notify("Sửa thành công");
      this.isEdit = false;
      });
    }
  }

  public enableEdit(){
    this.setTenPhongBan();
    this.setGioiTinh();
    this.isEdit = !this.isEdit;
    this.isUpload = !this.isUpload;
  }
  public cancleEdit(){
    this.getData(this.nv.id);
    this.setTenPhongBan();
    this.setGioiTinh();
    this.isEdit = false;
    this.isUpload = false;
  }
  public notify(notice){
    this.notificationService.success('success', notice, {
      timeOut: 2000,
      position: ['bottom', 'right']
    });
  }

  public view(n){
    this.func = n;
    this.setTitle(n);
  }

  public setTitle(n){
    if(n == 1){
      this.title = "Thông tin cơ bản";
    }
    if(n == 2){
      this.title = "Thông tin gia đình";
    }
    if(n == 3){
      this.title = "Quá trình đào tạo";
    }
    if(n == 4){
      this.title = "Quá trình công tác";
    }
    if(n == 5){
      this.title = "Bằng cấp chứng chỉ";
    }
  }

  public getData(id){
    this.nvService.getNhanVienById(id).subscribe(data => {
      this.nv = data.object;
      if(!this.nv.anh){
        if(this.nv.gioi_tinh){
          this.avatar = "./assets/static/images/avatar-male.png";
        } else {
          this.avatar = "./assets/static/images/avatar-female.png";
        }
      } else {
        this.avatar = 'data:image/png;base64,' + this.nv.anh;
      }
      this.setTenPhongBan();
      this.setGioiTinh();
    });
    this.nvService.getThongTinGiaDinh(id).subscribe(data=>{
      this.thongTinGiaDinh = data.list;
    });
    this.nvService.getQuaTrinhCongTac(id).subscribe(data=>{
      this.quaTrinhCongTac = data.list;
    });
    this.nvService.getQuaTrinhDaoTao(id).subscribe(data=>{
      this.quaTrinhDaoTao = data.list;
    });
    this.nvService.getBangCapChungChi(id).subscribe(data=>{
      this.bangCapChungChi = data.list;
    });
    this.nvService.getDanhGiaNhanVien(id).subscribe(data=>{
      this.danhGiaNhanVien = data.list;
    });
  }


}
