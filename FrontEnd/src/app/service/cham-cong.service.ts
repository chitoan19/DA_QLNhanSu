import { TinhLuongThangRequest } from './../request/tinh-luong-thang-request';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { ChamCongRequest } from '../request/cham-cong-request';
import { BaseHttpService } from './base-http.service';
import { ChamCong } from '../model/cham-cong';
import { Response } from '../response/response';
import { TinhLuongThang } from '../model/tinh-luong-thang';

@Injectable({
  providedIn: 'root'
})
export class ChamCongService {

  constructor(private http: BaseHttpService) { }

  public findAllOf(request: ChamCongRequest): Observable<Response<ChamCong>>{
    return this.http.post<Response<ChamCong>>(`cham-cong`, request);
  }

  public importFile(file: any): Observable<any>{
    return this.http.post<any>(`cham-cong/import-file`, file);
  }

  public getThongKeCongThang(request: TinhLuongThangRequest): Observable<Response<TinhLuongThang>>{
    return this.http.post<Response<TinhLuongThang>>(`luong-thang/list`, request);
  }

  public thongKe(request: ChamCongRequest): Observable<Response<TinhLuongThang>>{
    return this.http.post<Response<TinhLuongThang>>(`cham-cong/thong-ke`, request);
  };
}
