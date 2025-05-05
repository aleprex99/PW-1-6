import { TestBed } from '@angular/core/testing';

import { UtilizzoMensileService } from './utilizzo-mensile.service';

describe('UtilizzoMensileService', () => {
  let service: UtilizzoMensileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UtilizzoMensileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
