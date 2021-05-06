import { AuthService } from './../service/auth.service';
import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthResponse } from '../response/auth-response';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  constructor(private authService: AuthService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let currentUser = new AuthResponse();
    this.authService.authResponse.subscribe(data => {
      currentUser = data;
    });
    if(currentUser.user && currentUser.jwtToken){
      request = request.clone({
        setHeaders: {
          Authorization: `${currentUser.jwtToken}`
        }
      });
    }
    return next.handle(request);
  }
}
