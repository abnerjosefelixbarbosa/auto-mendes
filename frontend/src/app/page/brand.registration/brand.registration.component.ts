import { Component } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Message } from '../../utils/message';

@Component({
  selector: 'app-brand.registration',
  imports: [NavbarComponent, ReactiveFormsModule],
  templateUrl: './brand.registration.component.html',
  styleUrl: './brand.registration.component.css',
})
export class BrandRegistrationComponent {
  message = Message;
  form: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      name: ['', [Validators.required, Validators.maxLength(50)]],
    });
  }

  register() {
    try {
      this.message.SUCCESS = '';
      this.message.ERROR = '';

      const data = this.employeeMapper.toEmployeeRequestDTO(this.form);

      
    } catch (e: any) {
      const message = e.message;

      if (message == 'Comissão invalida.') {
        this.form.get('commission')?.setErrors({ commissionInvalid: true });
      }
    } 
  }
}
