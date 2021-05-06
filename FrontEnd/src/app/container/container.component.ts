import { NhanVienService } from './../service/nhan-vien.service';
import { NhanVien } from 'src/app/model/nhan-vien';
import { AuthService } from './../service/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TaiKhoan } from '../model/tai-khoan';
import { Response } from '../response/response';

@Component({
  selector: 'app-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.css']
})
export class ContainerComponent implements OnInit {
  tk = new TaiKhoan();
  nv = new NhanVien();
  constructor(private router: Router, private authService: AuthService, private nvService: NhanVienService) { }

  ngOnInit(): void {
    this.tk = JSON.parse(localStorage.getItem('currentUser'));
    this.nvService.getNhanVienById(this.tk.nhan_vien_id).subscribe(data=>{
      this.nv = data.object;
    });
  }

  logout(){
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
