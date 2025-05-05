import { TestBed } from '@angular/core/testing';

import { GaranziaService } from './garanzia.service';

describe('GaranziaService', () => {
  let service: GaranziaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GaranziaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
