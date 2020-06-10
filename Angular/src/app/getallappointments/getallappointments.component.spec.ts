import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetallappointmentsComponent } from './getallappointments.component';

describe('GetallappointmentsComponent', () => {
  let component: GetallappointmentsComponent;
  let fixture: ComponentFixture<GetallappointmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetallappointmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetallappointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
