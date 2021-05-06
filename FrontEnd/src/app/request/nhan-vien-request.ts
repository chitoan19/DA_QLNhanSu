export class NhanVienRequest {
  pageNum: number;
  pageSize: number;
  ho_ten: string;
  que_quan: string;
  ngay_sinh: Date;
  chuc_vu: string;
  phong_ban_id: number;
  dia_chi: string;
  gioi_tinh: number; // 0: nu, 1:nam, 2:all
  quyen: string;
  email: string;
  ten_dang_nhap: string;
  id: number;
  constructor(){
    this.pageNum = 1;
    this.pageSize = 5;
    this.gioi_tinh = 3;
  }
}
