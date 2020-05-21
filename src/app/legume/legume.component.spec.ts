import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LegumeComponent } from './legume.component';

describe('LegumeComponent', () => {
  let component: LegumeComponent;
  let fixture: ComponentFixture<LegumeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LegumeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LegumeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
