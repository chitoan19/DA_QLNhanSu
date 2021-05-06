import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NhanVienDetailComponent } from './nhan-vien-detail.component';

describe('NhanVienDetailComponent', () => {
  let component: NhanVienDetailComponent;
  let fixture: ComponentFixture<NhanVienDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NhanVienDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NhanVienDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
