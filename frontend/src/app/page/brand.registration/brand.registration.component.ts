import { Component, inject } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { messages } from '../../../backend/utils/message';
import { BrandService } from '../../service/brand/brand.service';
import { BrandMapper } from '../../../backend/mapper/brand.mapper';

@Component({
  selector: 'app-brand.registration',
  imports: [NavbarComponent, ReactiveFormsModule],
  templateUrl: './brand.registration.component.html',
  styleUrl: './brand.registration.component.css',
})
export class BrandRegistrationComponent {
  message = messages;
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
      this.cleanMessage();

      if (this.form.valid) {
        const dto = this.brandMapper.toBrandDTO(this.form);

        this.brandService
          .registerBrand(dto)
          .then(() => {
            this.message.sucess = 'Marca registrada.';

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
    this.form.get('name')?.setValue('');
  }

  private cleanMessage() {
    this.message.sucess = '';
    this.message.error = '';
  }
}
