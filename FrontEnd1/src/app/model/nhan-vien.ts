import { Byte } from "@angular/compiler/src/util";

export class NhanVien {
  id: number;
  ho_ten: string;
  ngay_sinh: Date;
  que_quan: string;
  dia_chi_hien_tai: string;
  cmnd: string;
  gioi_tinh: number;
  sdt: string;
  email: string;
  chuc_vu: string;
  chuc_danh: string;
  trinh_do_van_hoa: string;
  trinh_do_ngoai_ngu: string;
  so_nam_kinh_nghiem: number;
  anh: Byte[];
  ngay_ket_nap_doan: Date;
  ngay_ket_nap_dang: Date;
  bi_danh: string;
  dan_toc: string;
  ton_giao: string;
  thanh_phan_ban_than: string;
  noi_dang_ky_hktt: string;
  ma_so_thue: string;
  phong_ban_id: number;

  constructor(){

  }
}
