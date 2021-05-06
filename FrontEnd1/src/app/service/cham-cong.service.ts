import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { ChamCongRequest } from '../request/cham-cong-request';
import { BaseHttpService } from './base-http.service';
import { ChamCong } from '../model/cham-cong';
import { Response } from '../response/response';

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
}
