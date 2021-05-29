export class ChamCongRequest {
  pageNum: number;
  pageSize: number;
  ngay_thang: Date;
  nhan_vien_id: number;
  listIdnv: number[];
  thang: number;
  nam: number;
  nguoi_cham: string;
  constructor(){
    this.pageNum = 1;
    this.pageSize = 5;
  }
}
