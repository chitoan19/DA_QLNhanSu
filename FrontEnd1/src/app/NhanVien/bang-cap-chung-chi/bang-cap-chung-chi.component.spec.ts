import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BangCapChungChiComponent } from './bang-cap-chung-chi.component';

describe('BangCapChungChiComponent', () => {
  let component: BangCapChungChiComponent;
  let fixture: ComponentFixture<BangCapChungChiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BangCapChungChiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BangCapChungChiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
