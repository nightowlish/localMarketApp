import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NonpersihableComponent } from './nonpersihable.component';

describe('NonpersihableComponent', () => {
  let component: NonpersihableComponent;
  let fixture: ComponentFixture<NonpersihableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NonpersihableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NonpersihableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
