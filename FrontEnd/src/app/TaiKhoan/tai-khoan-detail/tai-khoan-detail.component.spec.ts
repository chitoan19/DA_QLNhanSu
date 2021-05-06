import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaiKhoanDetailComponent } from './tai-khoan-detail.component';

describe('TaiKhoanDetailComponent', () => {
  let component: TaiKhoanDetailComponent;
  let fixture: ComponentFixture<TaiKhoanDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaiKhoanDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TaiKhoanDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
