import { Component, inject } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { EmployeeRequestDTO, EmployeeService } from '../../service/employee/employee.service';
import { messages } from '../../utils/message';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';
import { EmployeeType } from '../../enum/employee_type';

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
  private type: EmployeeType = EmployeeType.MANAGER;
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

    this.form.get('employeeType')?.valueChanges.subscribe((value) => {
      if (value === '1') {
        this.type = EmployeeType.MANAGER;
      }

      if (value === '2') {
        this.type = EmployeeType.SUBMANAGER;
      }

      if (value === '3') {
        this.type = EmployeeType.SALER;
      }
    })
  }

  register() {
    try {
      this.message.sucess = '';
      this.message.error = '';
      
      if (this.form.valid) {
        const dto: EmployeeRequestDTO = {
          birthDate: this.form.get('birthDate')?.value,
          commission: this.form.get('commission')?.value,
          email: this.form.get('email')?.value,
          employeeType: this.type,
          matriculation: this.form.get('matriculation')?.value,
          name: this.form.get('name')?.value,
          phone: this.form.get('phone')?.value
        }  

        console.log(dto);
      } else {
        this.form.markAllAsTouched();
      }
    } catch (e: any) {
      const message = e.message;

      //if (message == 'Comissão invalida.') {
      //  this.form.get('commission')?.setErrors({ commissionInvalid: true });
      //}
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
