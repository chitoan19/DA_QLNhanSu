import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { BaseHttpService } from './base-http.service';
import { LuongRequest } from '../request/luong-request';
import { Luong } from '../model/luong';
import { Response } from '../response/response';

@Injectable({
  providedIn: 'root'
})
export class LuongServiceService {

  constructor(private http: BaseHttpService) { }

  public findAll(request: LuongRequest): Observable<Response<Luong>>{
    return this.http.post<Response<Luong>>(`luong`, request);
  }

  public findById(id: number): Observable<Response<Luong>>{
    return this.http.get<Response<Luong>>(`luong/${id}`);
  }

  public create(luong: Luong) : Observable<any>{
    return this.http.post<Luong>(`luong/add`, luong);
  }

  public update(luong: Luong): Observable<object>{
    return this.http.put(`luong/${luong.id}`, luong);
  }
}
