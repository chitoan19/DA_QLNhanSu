import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LuongComponent } from './luong.component';

describe('LuongComponent', () => {
  let component: LuongComponent;
  let fixture: ComponentFixture<LuongComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LuongComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LuongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
