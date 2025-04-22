import { Component, inject } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { EmployeeService } from '../../service/employee/employee.service';
import { EmployeeRequestDTO } from '../../dto/request/employee.request.dto';
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
      this.request = {
        birthDate: new Date(this.form.get('birthDate')?.value),
        commission: 0,
        email: '',
        employeeType: EmployeeType.ASSISTANT_MANAGER,
        matriculation: '',
        name: '',
        phone: ''
      }

      console.log(this.request);

      this.validateForm()
      
    } else {
      this.form.markAllAsTouched();
    }
  }

  validateForm() {
    let matriculation: string = this.form.get('matriculation')?.value
  }
}
