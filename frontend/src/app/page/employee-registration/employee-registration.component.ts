import { Component, inject } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { EmployeeService } from '../../service/employee/employee.service';
import { EmployeeRequestDTO } from '../../dto/request/employee.request.dto';
import { EmployeeType } from '../../enum/employee.type';
import { EmployeeResponseDTO } from '../../dto/response/employee.response.dto';
@Component({
  selector: 'app-employee-registration',
  imports: [NavbarComponent, ReactiveFormsModule],
  templateUrl: './employee-registration.component.html',
  styleUrl: './employee-registration.component.css',
  standalone: true
})
export class EmployeeRegistrationComponent {
  form: FormGroup;
  employeeService = inject(EmployeeService);
  request: EmployeeRequestDTO | null = null;

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      name: ['', [Validators.required, Validators.maxLength(100)]],
      email: ['', [Validators.required, Validators.email, Validators.maxLength(100)]],
      matriculation: ['', [Validators.required]],
      phone: ['', [Validators.required, Validators.maxLength(30)]],
      birthDate: ['', [Validators.required]],
      employeeType: ['', [Validators.required]],
      commission: ['', [Validators.required]]
    });
  }

  register() {
    if (this.form.valid) {
      this.toEmployeeRequestDTO();

      const response = this.employeeService.registreEmployee(this.request!);

      response
      .then((val) => console.log(val))
      .catch((e) => console.log(e));
    } else {
      this.form.markAllAsTouched();
    }
  }

  toEmployeeRequestDTO() {
    if (this.form.get('employeeType')?.value == 1) {
      this.request = {
        birthDate: new Date(this.form.get('birthDate')?.value),
        commission: this.form.get('commission')?.value,
        email: this.form.get('email')?.value,
        employeeType: EmployeeType.MANAGER,
        matriculation: this.form.get('matriculation')?.value,
        name: this.form.get('name')?.value,
        phone: this.form.get('phone')?.value
      }
    }

    if (this.form.get('employeeType')?.value == 2) {
      this.request = {
        birthDate: new Date(this.form.get('birthDate')?.value),
        commission: this.form.get('commission')?.value,
        email: this.form.get('email')?.value,
        employeeType: EmployeeType.ASSISTANT_MANAGER,
        matriculation: this.form.get('matriculation')?.value,
        name: this.form.get('name')?.value,
        phone: this.form.get('phone')?.value
      }
    }

    if (this.form.get('employeeType')?.value == 3) {
      this.request = {
        birthDate: new Date(this.form.get('birthDate')?.value),
        commission: this.form.get('commission')?.value,
        email: this.form.get('email')?.value,
        employeeType: EmployeeType.SALER,
        matriculation: this.form.get('matriculation')?.value,
        name: this.form.get('name')?.value,
        phone: this.form.get('phone')?.value
      }
    }
  }

  //name1
    //email1@gmail.com
    //11
    //(81) 91111-1111
    //01/01/1991
    //11
}