import { TestBed } from '@angular/core/testing';

import { SinistroService } from './sinistro.service';

describe('SinistroService', () => {
  let service: SinistroService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SinistroService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
