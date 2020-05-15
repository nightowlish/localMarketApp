import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HometoolsComponent } from './hometools.component';

describe('HometoolsComponent', () => {
  let component: HometoolsComponent;
  let fixture: ComponentFixture<HometoolsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HometoolsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HometoolsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
