import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DenunciaSinistroComponent } from './denuncia-sinistro.component';

describe('DenunciaSinistroComponent', () => {
  let component: DenunciaSinistroComponent;
  let fixture: ComponentFixture<DenunciaSinistroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DenunciaSinistroComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DenunciaSinistroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
