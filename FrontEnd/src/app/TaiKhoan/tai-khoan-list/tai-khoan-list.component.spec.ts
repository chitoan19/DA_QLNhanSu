import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaiKhoanListComponent } from './tai-khoan-list.component';

describe('TaiKhoanListComponent', () => {
  let component: TaiKhoanListComponent;
  let fixture: ComponentFixture<TaiKhoanListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaiKhoanListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TaiKhoanListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
