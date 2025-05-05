import { Component, inject } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { EmployeeService } from '../../service/employee.service';
import { EmployeeRequestDTO } from '../../service/employee.service';
import { Message } from '../../utils/message';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';
import { EmployeeType } from '../../utils/employee.type';

@Component({
  selector: 'app-employee-registration',
  imports: [NavbarComponent, ReactiveFormsModule, NgxMaskDirective],
  templateUrl: './employee-registration.component.html',
  styleUrl: './employee-registration.component.css',
  standalone: true,
  providers: [provideNgxMask()],
})
export class EmployeeRegistrationComponent {
  message = Message;
  dto: EmployeeRequestDTO | null = null;
  form: FormGroup;
  employeeService = inject(EmployeeService);

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      name: ['', [Validators.required, Validators.maxLength(100)]],
      email: ['', [Validators.required, Validators.email, Validators.maxLength(100)]],
      matriculation: ['', [Validators.required]],
      phone: ['', [Validators.required, Validators.maxLength(30)]],
      birthDate: ['', [Validators.required]],
      employeeType: ['', [Validators.required]],
      commission: ['', [Validators.required]],
    });
  }

  register() {
    this.message.SUCCESS = '';
    this.message.ERROR = '';

    this.validateRegisterForm(this.form);

    if (this.form.valid) {
      const data = this.createEmployeeRequestDTO(this.form)

      const response = this.employeeService.registreEmployee(data);

      response
        .then(() => {
          this.message.SUCCESS = 'Funcionário registrado com sucesso';
        })
        .catch((e) => {
          this.message.ERROR = e.error.message;
        });
    } else {
      this.form.markAllAsTouched();
    }
  }

  validateRegisterForm(form: FormGroup) {
    const matriculation = new String(form.get('matriculation')?.value);
    const employeeType = form.get('employeeType')?.value;

    if (matriculation.length !== 10 || employeeType === 3) {
      form.get('matriculation')?.setErrors({ matriculationInvalid: true });
    }
  }

  createEmployeeRequestDTO(form: FormGroup) {
    let data: EmployeeRequestDTO;

    if (form.get('employeeType')?.value == 1) {
      data = {
        birthDate: this.form.get('birthDate')?.value,
        commission: this.form.get('commission')?.value,
        email: this.form.get('email')?.value,
        employeeType: EmployeeType.MANAGER,
        matriculation: this.form.get('matriculation')?.value,
        name: this.form.get('name')?.value,
        phone: this.form.get('phone')?.value,
      };
    }

    if (form.get('employeeType')?.value == 2) {
      data = {
        birthDate: this.form.get('birthDate')?.value,
        commission: this.form.get('commission')?.value,
        email: this.form.get('email')?.value,
        employeeType: EmployeeType.ASSISTANT_MANAGER,
        matriculation: this.form.get('matriculation')?.value,
        name: this.form.get('name')?.value,
        phone: this.form.get('phone')?.value,
      };
    }

    if (form.get('employeeType')?.value == 3) {
      data = {
        birthDate: this.form.get('birthDate')?.value,
        commission: this.form.get('commission')?.value,
        email: this.form.get('email')?.value,
        employeeType: EmployeeType.SALER,
        matriculation: this.form.get('matriculation')?.value,
        name: this.form.get('name')?.value,
        phone: this.form.get('phone')?.value,
      };
    }

    return data!;
  }
}
