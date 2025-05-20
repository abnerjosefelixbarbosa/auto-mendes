import { Component, inject } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Message } from '../../utils/message';
import { BrandMapper } from '../../utils/brand.mapper';
import { BrandService } from '../../service/brand/brand.service';

@Component({
  selector: 'app-brand.registration',
  imports: [NavbarComponent, ReactiveFormsModule],
  templateUrl: './brand.registration.component.html',
  styleUrl: './brand.registration.component.css',
})
export class BrandRegistrationComponent {
  message = Message;
  form: FormGroup;
  private brandMapper = inject(BrandMapper);
  private brandService = inject(BrandService);

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      name: ['', [Validators.required, Validators.maxLength(50)]],
    });
  }

  register() {
    try {
      this.message.SUCCESS = '';
      this.message.ERROR = '';

      const data = this.brandMapper.toEmployeeRequestDTO(this.form);

      if (this.form.valid) {
        this.brandService.registerBrand(data)
        .then(() => {
          this.message.SUCCESS = 'Marca registrada com sucesso.'
        })
        .catch((e) => {
          const message = e.error.message;

          this.message.ERROR = message;
        })
      } else {
        this.form.markAllAsTouched();
      }
    } catch (e: any) {
      const message = e.message;

      if (message == 'Comissão invalida.') {
        this.form.get('commission')?.setErrors({ commissionInvalid: true });
      }
    }
  }
}
