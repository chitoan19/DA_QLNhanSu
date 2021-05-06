import { NhanVien } from 'src/app/model/nhan-vien';
import { User } from './../model/user';
import { AuthResponse } from './../response/auth-response';
import { AuthRequest } from './../request/auth-request';
import { AuthService } from './../service/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TaiKhoan } from '../model/tai-khoan';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  tk = new TaiKhoan();
  authRequest = new AuthRequest();
  error: string;
  hide = true;
  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    // this.loginForm = new FormGroup({
    //   username: new FormControl('', Validators.required),
    //   password: new FormControl('', Validators.required)
    // })
  }

  onSubmit(){
    console.log(this.authRequest);
    this.authService.login(this.authRequest).subscribe(data =>{
      this.tk = data;

      console.log(this.tk);
      if(this.tk == null){
        this.error = "Tài khoản hoặc mật khẩu không đúng !";
      } else {
        //localStorage.setItem('currentUser', JSON.stringify(this.tk));

      }
      this.router.navigate(['/dashboard']);

    }, error =>{
      this.error = "Lỗi đăng nhập";
    });
  }

}
