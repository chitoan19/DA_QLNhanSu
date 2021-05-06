import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThongKeCongThangComponent } from './thong-ke-cong-thang.component';

describe('ThongKeCongThangComponent', () => {
  let component: ThongKeCongThangComponent;
  let fixture: ComponentFixture<ThongKeCongThangComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ThongKeCongThangComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ThongKeCongThangComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
