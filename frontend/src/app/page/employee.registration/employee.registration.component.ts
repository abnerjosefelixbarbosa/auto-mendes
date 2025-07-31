import { Component, inject } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { messages } from '../../../backend/utils/message';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';
import { EmployeeMapper } from '../../../backend/mapper/employee.mapper';
import { EmployeeService } from '../../../backend/service/employee/employee.service';

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
      commission: ['', []],
    });
  }

  register() {
    try {
      this.cleanMessage();

      if (this.form.valid) {
        const dto = this.employeeMapper.toEmployeeDTO(
          this.form
        );

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
