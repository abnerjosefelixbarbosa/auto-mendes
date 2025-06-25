import { Component, inject } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { messages } from '../../utils/message';
import { BrandService } from '../../service/brand/brand.service';

@Component({
  selector: 'app-brand.registration',
  imports: [NavbarComponent, ReactiveFormsModule],
  templateUrl: './brand.registration.component.html',
  styleUrl: './brand.registration.component.css',
})
export class BrandRegistrationComponent {
  message = messages;
  form: FormGroup;
  private brandService = inject(BrandService);

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      name: ['', [Validators.required, Validators.maxLength(50)]],
    });
  }

  register() {
    try {
      this.message.sucess = '';
      this.message.error = '';

      if (this.form.valid) {
        
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
}
