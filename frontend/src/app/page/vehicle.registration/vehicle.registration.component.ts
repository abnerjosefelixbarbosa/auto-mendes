import { Component, inject } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { messages } from '../../../utils/message';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ModelMapper } from '../../../mapper/model.mapper';
import { ModelService } from '../../service/model/model.service';
import { VehicleMapper } from '../../../mapper/vehicle.mapper';
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
    const dto = this.vehicleMapper.toVehicleDTO(this.form);

    console.log(dto);
  }
}
