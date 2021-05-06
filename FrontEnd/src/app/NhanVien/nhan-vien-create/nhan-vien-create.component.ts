import { Response } from 'src/app/response/response';
import { NhanVienService } from 'src/app/service/nhan-vien.service';
import { NotificationsService } from 'angular2-notifications';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NhanVien } from 'src/app/model/nhan-vien';

@Component({
  selector: 'app-nhan-vien-create',
  templateUrl: './nhan-vien-create.component.html',
  styleUrls: ['./nhan-vien-create.component.css']
})
export class NhanVienCreateComponent implements OnInit {
  nv = new NhanVien();
  nvRes = new Response<NhanVien>();
  constructor(private router: Router, private notificationService: NotificationsService, private nvService: NhanVienService) { }

  ngOnInit(): void {

  }

  public back(){
    this.router.navigate(['dashboard/nhan-vien']);
  }

  public notity(message){
    this.notificationService.success('success', message,{
      timeOut: 2000,
      position: ['bottom', 'right']
    });
  }

  public warning(err){
    this.notificationService.error('error',  err,{
      timeOut: 2000
    });
  }

  public obSubmit(){

    if(Object.values(this.nv).length <= 0){
      this.warning('Bạn cần nhập đầy đủ dữ liệu');
    } else {
      this.nvService.create(this.nv).subscribe(data =>{
        this.nvRes = data;
        if(this.nvRes.result !== null){
          this.notity('Thêm thành công');
          this.back();
        }
      });
    }
  }
}
