import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SimpleNotificationComponent } from './simple-notification.component';

describe('SimpleNotificationComponent', () => {
  let component: SimpleNotificationComponent;
  let fixture: ComponentFixture<SimpleNotificationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SimpleNotificationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SimpleNotificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
