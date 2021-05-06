import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DanhGiaNhanVienComponent } from './danh-gia-nhan-vien.component';

describe('DanhGiaNhanVienComponent', () => {
  let component: DanhGiaNhanVienComponent;
  let fixture: ComponentFixture<DanhGiaNhanVienComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DanhGiaNhanVienComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DanhGiaNhanVienComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
