import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FructeComponent } from './fructe.component';

describe('FructeComponent', () => {
  let component: FructeComponent;
  let fixture: ComponentFixture<FructeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FructeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FructeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
