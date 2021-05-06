

export class AuthRequest {
  pageNum: number;
  pageSize: number;
  ten_dang_nhap: String;
  mat_khau: String;
  quyen: number;
  tu_ngay: Date;
  den_ngay: Date;
  trang_thai:number;
  id: number;
  constructor(){
    this.pageNum = 1;
    this.pageSize = 5;
    this.quyen = -1;
    this.trang_thai = -1;
  }
}
