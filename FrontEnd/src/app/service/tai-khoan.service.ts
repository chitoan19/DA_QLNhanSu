import { TaiKhoan } from './../model/tai-khoan';
import { AuthRequest } from './../request/auth-request';
import { Injectable } from '@angular/core';
import { BaseHttpService } from './base-http.service';
import { Observable } from 'rxjs';
import { Response } from '../response/response';

@Injectable({
  providedIn: 'root'
})
export class TaiKhoanService {

  constructor(private http: BaseHttpService) { }
  public findAll(request: AuthRequest): Observable<Response<TaiKhoan>>{
    return this.http.post<Response<TaiKhoan>>(`tai-khoan`, request);
  }

  public create(tk: TaiKhoan) : Observable<any>{
    return this.http.post<TaiKhoan>(`tai-khoan/add`, tk);
  }

  public delete(id: number) : Observable<any>{
    return this.http.delete(`tai-khoan/${id}`);//trùng với URL mapping bên server
  }

  public update(tk: TaiKhoan): Observable<any>{
    return this.http.put(`tai-khoan/${tk.id}`, tk);
  }

  public getNhanVien(tk: TaiKhoan) : Observable<any>{
    return this.http.post<Response<TaiKhoan>>(`tai-khoan/${tk.id}`, tk);
  }

  public getAllTaiKhoan(): Observable<any>{
    return this.http.get<any>(`tai-khoan/getall`);
  }
}
