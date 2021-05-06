export class ChamCongRequest {
  pageNum: number;
  pageSize: number;
  ngay_thang: Date;
  nhan_vien_id: number;
  thang: number;
  nam: number;
  constructor(){
    this.pageNum = 1;
    this.pageSize = 5;
  }
}
