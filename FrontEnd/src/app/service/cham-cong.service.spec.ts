import { TestBed } from '@angular/core/testing';

import { ChamCongService } from './cham-cong.service';

describe('ChamCongService', () => {
  let service: ChamCongService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChamCongService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
