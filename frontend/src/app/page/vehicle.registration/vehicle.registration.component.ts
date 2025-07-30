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
import { ModelService } from '../../service/model/model.service';
import { VehicleMapper } from '../../../backend/mapper/vehicle.mapper';
import { VehicleService } from '../../service/vehicle/vehicle.service';

@Component({
  selector: 'app-vehicle.registration',
  imports: [NavbarComponent, ReactiveFormsModule],
  templateUrl: './vehicle.registration.component.html',
  styleUrl: './vehicle.registration.component.css',
})
export class VehicleRegistrationComponent {
  message = messages;
  form: FormGroup;
  private vehicleMapper = inject(VehicleMapper);
  private vehicleService = inject(VehicleService);

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      plate: ['', []],
      transmissionType: ['', [Validators.required]],
      price: ['', [Validators.required]],
      modelName: ['', [Validators.required, Validators.maxLength(50)]],
      vehicleType: ['', [Validators.required]],
    });
  }

  register() {
    this.cleanMessage();

    const dto = this.vehicleMapper.toVehicleDTO(this.form);

    try {
      if (this.form.valid) {
        this.vehicleService
          .registerVehicle(dto)
          .then(() => {
            this.message.sucess = 'Veículo registrado.';

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
    this.form.get('modelName')?.setValue('');
    this.form.get('plate')?.setValue('');
    this.form.get('price')?.setValue('');
    this.form.get('transmissionType')?.setValue('');
    this.form.get('vehicleType')?.setValue('');
  }

  private cleanMessage() {
    this.message.sucess = '';
    this.message.error = '';
  }
}
