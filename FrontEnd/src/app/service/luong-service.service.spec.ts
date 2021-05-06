import { TestBed } from '@angular/core/testing';

import { LuongServiceService } from './luong-service.service';

describe('LuongServiceService', () => {
  let service: LuongServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LuongServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
