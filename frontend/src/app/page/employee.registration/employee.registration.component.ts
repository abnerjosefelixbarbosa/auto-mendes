import { Component, inject } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import {
  EmployeeRequestDTO,
  EmployeeService,
} from '../../service/employee/employee.service';
import { messages } from '../../utils/message';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';
import { EmployeeType } from '../../enum/employee_type';
import { EmployeeValidation } from './../../validation/employee.validation';

@Component({
  selector: 'app-employee-registration',
  imports: [NavbarComponent, ReactiveFormsModule, NgxMaskDirective],
  templateUrl: './employee.registration.component.html',
  styleUrl: './employee.registration.component.css',
  standalone: true,
  providers: [provideNgxMask()],
})
export class EmployeeRegistrationComponent {
  message = messages;
  form: FormGroup;
  private employeeService = inject(EmployeeService);

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      name: ['', [Validators.required, Validators.maxLength(100)]],
      email: [
        '',
        [Validators.required, Validators.email, Validators.maxLength(100)],
      ],
      matriculation: [
        '',
        [
          Validators.required,
          Validators.minLength(10),
          Validators.maxLength(10),
        ],
      ],
      phone: ['', [Validators.required, Validators.maxLength(30)]],
      birthDate: ['', [Validators.required]],
      employeeType: ['', [Validators.required]],
      commission: ['', []],
    });
  }

  register() {
    try {
      this.cleanMessage();

      if (this.form.valid) {
        const dto: EmployeeRequestDTO = this.transferEmployeeDTO(this.form);

        this.employeeService
          .registreEmployee(dto)
          .then(() => {
            this.message.sucess = 'Funcionário regidtrado.';

            this.cleanForm();
          })
          .catch((e) => {
            this.message.error = e.error.message;
          });
      } else {
        this.form.markAllAsTouched();
      }
    } catch (e: any) {
      this.message.error = e.message;
    }
  }

  private transferEmployeeDTO(form: FormGroup) {
    let select: EmployeeType = EmployeeType.MANAGER;

    if (form.get('employeeType')?.value == 2) {
      select = EmployeeType.SUBMANAGER;
    }

    if (form.get('employeeType')?.value == 3) {
      select = EmployeeType.SALER;
    }

    const dto: EmployeeRequestDTO = {
      birthDate: this.form.get('birthDate')?.value,
      commission: new Number(this.form.get('commission')?.value).toFixed(2),
      email: this.form.get('email')?.value,
      employeeType: select,
      matriculation: this.form.get('matriculation')?.value,
      name: this.form.get('name')?.value,
      phone: this.form.get('phone')?.value,
    };

    return dto;
  }

  private cleanForm() {
    this.form.get('birthDate')?.setValue('');
    this.form.get('commission')?.setValue('');
    this.form.get('email')?.setValue('');
    this.form.get('typeEmployee')?.setValue('');
    this.form.get('matriculation')?.setValue('');
    this.form.get('name')?.setValue('');
    this.form.get('phone')?.setValue('');
  }

  private cleanMessage() {
    this.message.sucess = '';
    this.message.error = '';
  }
}
