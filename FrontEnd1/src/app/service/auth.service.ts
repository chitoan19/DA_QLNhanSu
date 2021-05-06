import { TaiKhoan } from './../model/tai-khoan';
import { AuthRequest } from './../request/auth-request';
import { NhanVien } from './../model/nhan-vien';
import { BehaviorSubject, Observable } from 'rxjs';
import { BaseHttpService } from './base-http.service';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { AuthResponse } from '../response/auth-response';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  //private currentUserSubject: BehaviorSubject<AuthResponse>;
  //public authResponse: Observable<AuthResponse>;
  constructor(private http: BaseHttpService) {
    //this.currentUserSubject = new BehaviorSubject<AuthResponse>(JSON.parse(localStorage.getItem('currentUser')));
    //this.authResponse = this.currentUserSubject.asObservable();
  }

  public login(authRequest: AuthRequest){
    return this.http.post<TaiKhoan>(`login`, authRequest).pipe(map(tk => {
      localStorage.setItem('currentUser', JSON.stringify(tk));
      //this.currentUserSubject.next(user);
      return tk;
    }));
  }

  public logout(){
    localStorage.removeItem('currentUser');
    //this.currentUserSubject.next(null);
  }
}
