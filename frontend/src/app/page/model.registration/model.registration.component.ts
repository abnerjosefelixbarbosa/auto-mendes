import { Component, inject } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { messages } from '../../../backend/utils/message';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ModelMapper } from '../../../backend/mapper/model.mapper';
import { ModelService } from '../../../backend/service/model/model.service';

@Component({
  selector: 'app-model.registration',
  imports: [NavbarComponent, ReactiveFormsModule],
  templateUrl: './model.registration.component.html',
  styleUrl: './model.registration.component.css',
})
export class ModelRegistrationComponent {
  message = messages;
  form: FormGroup;
  private modelMapper = inject(ModelMapper);
  private modelService = inject(ModelService);

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      name: ['', [Validators.required, Validators.maxLength(50)]],
      brandName: ['', [Validators.required, Validators.maxLength(50)]],
    });
  }

  register() {
    this.cleanMessage();

    try {
      if (this.form.valid) {
        const dto = this.modelMapper.toBrandDTO(this.form);

        this.modelService
          .registerModel(dto)
          .then(() => {
            this.message.sucess = 'Modelo registrado.';

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
    this.form.get('brandName')?.setValue('');
  }

  private cleanMessage() {
    this.message.sucess = '';
    this.message.error = '';
  }
}
