import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NhanVienCreateComponent } from './nhan-vien-create.component';

describe('NhanVienCreateComponent', () => {
  let component: NhanVienCreateComponent;
  let fixture: ComponentFixture<NhanVienCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NhanVienCreateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NhanVienCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
