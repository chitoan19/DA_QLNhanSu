import { DanhGiaNhanVien } from './../model/danh-gia-nhan-vien';
import { QuaTrinhDaoTao } from './../model/qua-trinh-dao-tao';
import { ThongTinGiaDinh } from './../model/thong-tin-gia-dinh';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NhanVien } from '../model/nhan-vien';
import { NhanVienRequest } from '../request/nhan-vien-request';
import { Response } from '../response/response';
import { BaseHttpService } from './base-http.service';
import { QuaTrinhCongTac } from '../model/qua-trinh-cong-tac';
import { BangCapChungChi } from '../model/bang-cap-chung-chi';

@Injectable({
  providedIn: 'root'
})
export class NhanVienService {

  constructor(private http: BaseHttpService) { }
  public findAll(request: NhanVienRequest): Observable<Response<NhanVien>>{
    return this.http.post<Response<NhanVien>>(`nhan-vien`, request);
  }

  public create(nv: NhanVien) : Observable<any>{
    return this.http.post<NhanVien>(`nhan-vien/add`, nv);
  }

  public delete(id: number) : Observable<object>{
    return this.http.delete(`nhan-vien/${id}`);//trùng với URL mapping bên server
  }

  public update(nv: NhanVien): Observable<object>{
    return this.http.put(`nhan-vien/${nv.id}`, nv);
  }

  public getNhanVien(nv: NhanVien) : Observable<any>{
    return this.http.post<Response<NhanVien>>(`nhan-vien/${nv.id}`, nv);
  }

  public getNhanVienById(id: Number) : Observable<any>{
    return this.http.get<Response<NhanVien>>(`nhan-vien/${id}`);
  }

  public getAllNhanVien(): Observable<any>{
    return this.http.get<any>(`nhan-vien/getall`);
  }

  public getThongTinGiaDinh(id: Number):Observable<any>{
    return this.http.get<any>(`thong-tin-gia-dinh/${id}`);
  }

  public getQuaTrinhCongTac(id: Number):Observable<any>{
    return this.http.get<any>(`qua-trinh-cong-tac/${id}`);
  }

  public getQuaTrinhDaoTao(id: Number):Observable<any>{
    return this.http.get<any>(`qua-trinh-dao-tao/${id}`);
  }

  public getBangCapChungChi(id: Number):Observable<any>{
    return this.http.get<any>(`bang-cap-chung-chi/${id}`);
  }

  public getDanhGiaNhanVien(id: Number):Observable<any>{
    return this.http.get<any>(`danh-gia-nhan-vien/${id}`);
  }

  //thong tin gia dinh
  public saveThongTinGD(item: any, idnv: Number):Observable<any>{
    return this.http.put<any>(`thong-tin-gia-dinh/${idnv}`, item);
  }
  public delThongTinGD(id: Number, idnv: Number):Observable<any>{
    return this.http.delete<any>(`thong-tin-gia-dinh/${id}/${idnv}`);
  }
  public addThongTinGD(item: any, idnv: Number):Observable<any>{
    return this.http.post<any>(`thong-tin-gia-dinh/${idnv}`, item);
  }
  //qua trinh dao tao
  public saveQTDaoTao(item: any, idnv: Number):Observable<any>{
    return this.http.put<any>(`qua-trinh-dao-tao/${idnv}`, item);
  }
  public delQTDaoTao(id: Number, idnv: Number):Observable<any>{
    return this.http.delete<any>(`qua-trinh-dao-tao/${id}/${idnv}`);
  }
  public addQTDaoTao(item: any, idnv: Number):Observable<any>{
    return this.http.post<any>(`qua-trinh-dao-tao/${idnv}`, item);
  }
  //qua trinh dao tao
  public saveQTCongTac(item: any, idnv: Number):Observable<any>{
    return this.http.put<any>(`qua-trinh-cong-tac/${idnv}`, item);
  }
  public delQTCongTaco(id: Number, idnv: Number):Observable<any>{
    return this.http.delete<any>(`qua-trinh-cong-tac/${id}/${idnv}`);
  }
  public addQTCongTac(item: any, idnv: Number):Observable<any>{
    return this.http.post<any>(`qua-trinh-cong-tac/${idnv}`, item);
  }
  //bang cap chung chi
  public saveBCCC(item: any, idnv: Number):Observable<any>{
    return this.http.put<any>(`bang-cap-chung-chi/${idnv}`, item);
  }
  public delBCCC(id: Number, idnv: Number):Observable<any>{
    return this.http.delete<any>(`bang-cap-chung-chi/${id}/${idnv}`);
  }
  public addBCCC(item: any, idnv: Number):Observable<any>{
    return this.http.post<any>(`bang-cap-chung-chi/${idnv}`, item);
  }
  public uploadAvatar(file: any, idnv: Number):Observable<any>{
    return this.http.post<any>(`upload-avatar/${idnv}`, file);
  }
}
