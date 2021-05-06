import { MapComponent } from './map/map.component';
import { ChamCongComponent } from './ChamCong/cham-cong/cham-cong.component';
import { MyAcountComponent } from './my-acount/my-acount.component';
import { TaiKhoanCreateComponent } from './TaiKhoan/tai-khoan-create/tai-khoan-create.component';
import { TaiKhoanDetailComponent } from './TaiKhoan/tai-khoan-detail/tai-khoan-detail.component';
import { TaiKhoanListComponent } from './TaiKhoan/tai-khoan-list/tai-khoan-list.component';
import { NhanVienDetailComponent } from './NhanVien/nhan-vien-detail/nhan-vien-detail.component';
import { NhanVienListComponent } from './NhanVien/nhan-vien-list/nhan-vien-list.component';
import { ContainerComponent } from './container/container.component';
import { LoginComponent } from './login/login.component';
import { TrangChuComponent } from './trang-chu/trang-chu.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule, CanActivate } from '@angular/router';
import { AuthGuard } from './authHelper/auth.guard';
import { NhanVienCreateComponent } from './NhanVien/nhan-vien-create/nhan-vien-create.component';
import { PersonalInforComponent } from './NhanVien/personal-infor/personal-infor.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { LuongComponent } from './luong/luong.component';
import { ThongKeCongThangComponent } from './ChamCong/thong-ke-cong-thang/thong-ke-cong-thang.component';

const routes: Routes = [
  {path: 'dashboard', component: ContainerComponent, canActivate:[AuthGuard],
    children: [
      {path: '', redirectTo: 'home', pathMatch: 'full'},
      {path: 'home', component: TrangChuComponent},
      {path: 'nhan-vien', component: NhanVienListComponent},
      {path: 'nhan-vien/add', component: NhanVienCreateComponent},
      {path: 'nhan-vien/detail/:id', component: NhanVienDetailComponent},
      {path: 'info/:id', component: PersonalInforComponent},
      {path: 'myaccount/:id', component: MyAcountComponent},
      {path: 'tai-khoan', component: TaiKhoanListComponent},
      {path: 'tai-khoan/add', component: TaiKhoanCreateComponent},
      {path: 'tai-khoan/detail/:id', component: TaiKhoanDetailComponent},
      {path: 'cham-cong', component: ChamCongComponent},
      {path: 'thong-ke', component: ThongKeCongThangComponent},
      {path: 'luong', component: LuongComponent},
      {path: 'location', component: MapComponent}
    ]
  },
  {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: '404', component: NotFoundComponent},
  {path: '**', redirectTo: '/404'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
