import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioPolizzaComponent } from './dettaglio-polizza.component';

describe('DettaglioPolizzaComponent', () => {
  let component: DettaglioPolizzaComponent;
  let fixture: ComponentFixture<DettaglioPolizzaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DettaglioPolizzaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DettaglioPolizzaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
