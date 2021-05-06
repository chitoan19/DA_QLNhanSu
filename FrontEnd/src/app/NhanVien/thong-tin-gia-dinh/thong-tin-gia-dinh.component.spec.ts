import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThongTinGiaDinhComponent } from './thong-tin-gia-dinh.component';

describe('ThongTinGiaDinhComponent', () => {
  let component: ThongTinGiaDinhComponent;
  let fixture: ComponentFixture<ThongTinGiaDinhComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ThongTinGiaDinhComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ThongTinGiaDinhComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
