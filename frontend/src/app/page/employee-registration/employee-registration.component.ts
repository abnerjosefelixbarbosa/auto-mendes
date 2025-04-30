import { Component, inject } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import { EmployeeService } from '../../service/employee.service';
import { EmployeeRequestDTO } from '../../dto/employee.request.dto';
import { EmployeeValidation } from '../../utils/employee.validation';
import { Message } from '../../utils/message';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';

@Component({
  selector: 'app-employee-registration',
  imports: [
    NavbarComponent,
    ReactiveFormsModule,
    NgxMaskDirective
],
  templateUrl: './employee-registration.component.html',
  styleUrl: './employee-registration.component.css',
  standalone: true,
  providers: [provideNgxMask()]
})
export class EmployeeRegistrationComponent {
  message = Message; 
  dto: EmployeeRequestDTO | null = null;
  form: FormGroup;
  employeeService = inject(EmployeeService);
  employeeValidation = inject(EmployeeValidation);

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      name: ['', [Validators.required, Validators.maxLength(100)]],
      email: ['',[Validators.required, Validators.email, Validators.maxLength(100)],],
      matriculation: ['', [Validators.required]],
      phone: ['', [Validators.required, Validators.maxLength(30)]],
      birthDate: ['', [Validators.required]],
      employeeType: ['', [Validators.required]],
      commission: ['', [Validators.required]],
    });
  }

  register() {
    this.message.SUCCESS = ''
    this.message.ERROR = ''

    this.employeeValidation.validateRegisterForm(this.form);

    if (this.form.valid) {
      const response = this.employeeService.registreEmployee(this.form);

      response.then(() => {
        this.message.SUCCESS = 'Funcionário registrado com sucesso'
      }).catch((e) => { 
        this.message.ERROR = e.error.message
      });
    } else {
      this.form.markAllAsTouched();
    }
  }
}
