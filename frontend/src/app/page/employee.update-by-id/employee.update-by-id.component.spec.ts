import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeUpdateByIdComponent } from './employee.update-by-id.component';

describe('EmployeeUpdateByIdComponent', () => {
  let component: EmployeeUpdateByIdComponent;
  let fixture: ComponentFixture<EmployeeUpdateByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmployeeUpdateByIdComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmployeeUpdateByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
