import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetallTestsComponent } from './getall-tests.component';

describe('GetallTestsComponent', () => {
  let component: GetallTestsComponent;
  let fixture: ComponentFixture<GetallTestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetallTestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetallTestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
