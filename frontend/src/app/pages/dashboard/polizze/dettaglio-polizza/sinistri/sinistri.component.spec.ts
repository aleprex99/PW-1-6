import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SinistriComponent } from './sinistri.component';

describe('SinistriComponent', () => {
  let component: SinistriComponent;
  let fixture: ComponentFixture<SinistriComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SinistriComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SinistriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
