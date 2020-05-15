import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CleanindproductsComponent } from './cleanindproducts.component';

describe('CleanindproductsComponent', () => {
  let component: CleanindproductsComponent;
  let fixture: ComponentFixture<CleanindproductsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CleanindproductsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CleanindproductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
