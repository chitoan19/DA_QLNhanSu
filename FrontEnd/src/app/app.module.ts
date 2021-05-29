import { RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule} from '@angular/material/dialog';
import { ConfirmDialogComponent } from './confirm-dialog/confirm-dialog.component';
import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TrangChuComponent } from './trang-chu/trang-chu.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SimpleNotificationsModule } from 'angular2-notifications';
import { LoginComponent } from './login/login.component';
import { ContainerComponent } from './container/container.component';
import { NhanVienListComponent } from './NhanVien/nhan-vien-list/nhan-vien-list.component';
import { NhanVienCreateComponent } from './NhanVien/nhan-vien-create/nhan-vien-create.component';
import { NhanVienDetailComponent } from './NhanVien/nhan-vien-detail/nhan-vien-detail.component';
import { PersonalInforComponent } from './NhanVien/personal-infor/personal-infor.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { TaiKhoanListComponent } from './TaiKhoan/tai-khoan-list/tai-khoan-list.component';
import { TaiKhoanCreateComponent } from './TaiKhoan/tai-khoan-create/tai-khoan-create.component';
import { TaiKhoanDetailComponent } from './TaiKhoan/tai-khoan-detail/tai-khoan-detail.component';
import { ThongTinGiaDinhComponent } from './NhanVien/thong-tin-gia-dinh/thong-tin-gia-dinh.component';
import { QuaTrinhCongTacComponent } from './NhanVien/qua-trinh-cong-tac/qua-trinh-cong-tac.component';
import { BangCapChungChiComponent } from './NhanVien/bang-cap-chung-chi/bang-cap-chung-chi.component';
import { QuaTrinhDaoTaoComponent } from './NhanVien/qua-trinh-dao-tao/qua-trinh-dao-tao.component';
import { DanhGiaNhanVienComponent } from './NhanVien/danh-gia-nhan-vien/danh-gia-nhan-vien.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MyAcountComponent } from './my-acount/my-acount.component';
import { ChamCongComponent } from './ChamCong/cham-cong/cham-cong.component';
import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatFormFieldModule} from '@angular/material/form-field';
import { LuongComponent } from './luong/luong.component';
import { MapComponent } from './map/map.component';
import { ThongKeCongThangComponent } from './ChamCong/thong-ke-cong-thang/thong-ke-cong-thang.component';
import { NgxMatSelectSearchModule } from 'ngx-mat-select-search';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';

@NgModule({
  declarations: [
    AppComponent,
    TrangChuComponent,
    ConfirmDialogComponent,
    LoginComponent,
    ContainerComponent,
    NhanVienListComponent,
    NhanVienCreateComponent,
    NhanVienDetailComponent,
    PersonalInforComponent,
    NotFoundComponent,
    TaiKhoanListComponent,
    TaiKhoanCreateComponent,
    TaiKhoanDetailComponent,
    ThongTinGiaDinhComponent,
    QuaTrinhCongTacComponent,
    BangCapChungChiComponent,
    QuaTrinhDaoTaoComponent,
    DanhGiaNhanVienComponent,
    MyAcountComponent,
    ChamCongComponent,
    LuongComponent,
    MapComponent,
    ThongKeCongThangComponent
  ],
  entryComponents: [ConfirmDialogComponent],
  imports: [
    BrowserModule,
    RouterModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    NgxPaginationModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule,
    MatSelectModule,
    MatFormFieldModule,
    MatSlideToggleModule,
    MatExpansionModule,
    NgxMatSelectSearchModule,
    ReactiveFormsModule,
    SimpleNotificationsModule.forRoot(),
    NgbModule

  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
