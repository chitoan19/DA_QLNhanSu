import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BaseHttpService {

  private baseUrl: string;
  constructor(private http: HttpClient){
    this.baseUrl = 'http://localhost:8080/api';
  }

  get<T>(url: string): Observable<T>{
    return this.http.get<T>(`${this.baseUrl}/${url}`);
  }

  post<T>(url: string, body: any): Observable<T>{
    return this.http.post<T>(`${this.baseUrl}/${url}`, body);
  }

  put<T>(url: string, body: any): Observable<T>{
    return  this.http.put<T>(`${this.baseUrl}/${url}`, body);
  }

  delete<T>(url: string): Observable<T>{
    return this.http.delete<T>(`${this.baseUrl}/${url}`);
  }

}
