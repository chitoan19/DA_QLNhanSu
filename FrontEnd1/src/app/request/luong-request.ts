export class LuongRequest {
  pageNum: number;
  pageSize: number;
  nhan_vien_id: number;
  constructor(){
    this.pageNum = 1;
    this.pageSize = 5;
  }
}
