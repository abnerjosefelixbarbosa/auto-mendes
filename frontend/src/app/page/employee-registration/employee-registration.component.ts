import { Component, inject } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { EmployeeService } from '../../service/employee.service';
import { Message } from '../../utils/message';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';
import { EmployeeMapper } from '../../utils/employee.mapper';

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
  form: FormGroup;
  private employeeService = inject(EmployeeService);
  private employeeMapper = inject(EmployeeMapper);

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
      commission: ['', [Validators.required]],
    });
  }

  register() {
    try {
      this.message.SUCCESS = '';
      this.message.ERROR = '';

      let data = this.employeeMapper.toEmployeeRequestDTO(this.form);

      if (this.form.valid) {
        this.employeeService
          .registreEmployee(data)
          .then(() => {
            this.message.SUCCESS = 'Funcionário registrado com sucesso';
            this.cleanForm();
          })
          .catch((e) => {
            this.message.ERROR = e.error.message;
          });
      } else {
        this.form.markAllAsTouched();
      }
    } catch (e: any) {
      if (e.message == 'Comissão invalida.') {
        this.form.get('commission')?.setErrors({ commissionInvalid: true });
      }
    } 
  }

  cleanForm() {
    this.form.get('name')?.setValue('');
    this.form.get('email')?.setValue('');
    this.form.get('matriculation')?.setValue('');
    this.form.get('phone')?.setValue('');
    this.form.get('birthDate')?.setValue('');
    this.form.get('employeeType')?.setValue('');
    this.form.get('commission')?.setValue('');
  }
}
