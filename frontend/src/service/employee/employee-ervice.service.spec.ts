import { TestBed } from '@angular/core/testing';

import { EmployeeErviceService } from './employee-ervice.service';

describe('EmployeeErviceService', () => {
  let service: EmployeeErviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmployeeErviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
