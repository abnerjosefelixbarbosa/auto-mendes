import { Component, inject } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { EmployeeService } from '../../service/employee/employee.service';
import { EmployeeRequestDTO } from './../../dto/employee-request-dto';
import { EmployeeType } from '../../enum/employee.type';
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
  employeeRequestDTO: EmployeeRequestDTO | null = null;

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      name: ['', [Validators.required, Validators.maxLength(100)]],
      email: ['', [Validators.required, Validators.email, Validators.maxLength(100)]],
      matriculation: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
      phone: ['', [Validators.required, Validators.maxLength(30)]],
      birthDate: ['', [Validators.required]],
      employeeType: ['', [Validators.required]],
      commission: ['', [Validators.required]]
    });
  }

  register() {
    if (this.form.valid) {
      console.log(this.form.value);

      this.employeeRequestDTO = {
        birthDate: this.form.get('birthDate'),
        commission: this.form.get('commission'),
        email: this.form.get('email'),
        employeeType: EmployeeType.MANAGER,
        matriculation: this.form.get('matriculation'),
        name: this.form.get('name'),
        phone: this.form.get('phone'),
      }
    } else {
      this.form.markAllAsTouched();
    }
  }
}
