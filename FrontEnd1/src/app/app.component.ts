import { AuthResponse } from './response/auth-response';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'Danh sách vật tư';
  status = '';
  authResponse: AuthResponse;
  constructor( private http: HttpClient, private router: Router){
  }




}
