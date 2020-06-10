import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetallCentersComponent } from './getall-centers.component';

describe('GetallCentersComponent', () => {
  let component: GetallCentersComponent;
  let fixture: ComponentFixture<GetallCentersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetallCentersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetallCentersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
