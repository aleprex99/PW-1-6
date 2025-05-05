import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PolizzeComponent } from './polizze.component';

describe('PolizzeComponent', () => {
  let component: PolizzeComponent;
  let fixture: ComponentFixture<PolizzeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PolizzeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PolizzeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
