import { Component, inject, OnInit } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import {
  VehicleResponseDTO,
  VehicleService,
} from '../../service/vehicle/vehicle.service';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { messages } from '../../../backend/utils/message';
import { VehicleMapper } from '../../../backend/mapper/vehicle.mapper';

@Component({
  selector: 'app-vehicle.listing',
  imports: [NavbarComponent, ReactiveFormsModule],
  templateUrl: './vehicle.listing.component.html',
  styleUrl: './vehicle.listing.component.css',
})
export class VehicleListingComponent implements OnInit {
  items = new Array<VehicleResponseDTO>();
  item: VehicleResponseDTO | null = null;
  form: FormGroup;
  message = messages;
  id: string = '';
  private vehicleService = inject(VehicleService);
  private vehicleMapper = inject(VehicleMapper);

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      id: [''],
      modelName: ['', [Validators.required, Validators.maxLength(20)]],
      plate: [
        '', [],
      ],
      price: [
        '',
        [
          Validators.required
        ],
      ],
      transmissionType: ['', [Validators.required]],
      vehicleType: ['', [Validators.required]]
    });
  }

  ngOnInit() {
    this.vehicleService.listVehicles().then((value) => {
      this.items = value;
    });
  }

  update(item: VehicleResponseDTO) {
    this.cleanMessage();

    this.replace(item);
  }

  confirm() {
    this.cleanMessage();

    const id: string = this.form.get('id')?.value;

    const dto = this.vehicleMapper.toVehicleDTO(this.form);

    console.log(dto)

    try {
      if (this.form.valid) {
        this.vehicleService
        .updateVehicleById(id!, dto)
        .then(() => {
          this.message.sucess = 'Veículo atualizado.';

          setTimeout(() => {
            location.reload();
          }, 2000);
        })
        .catch((e) => (this.message.error = e.error.message));
      } else {
        this.form.markAllAsTouched();
      }
    } catch (e: any) {
      this.message.error = e.message;
    }
  }

  private replace(item: VehicleResponseDTO) {
    this.form.get('id')?.setValue(item.id);
    this.form.get('modelName')?.setValue(item.modelName);
    this.form.get('price')?.setValue(item.price);
    
    if (item.plate != null) {
      this.form.get('plate')?.setValue(item.plate);
    } else {
      this.form.get('plate')?.setValue(null);
    }

    if (item.transmissionType.toString() == 'AUTO') {
      this.form.get('transmissionType')?.setValue('1');
    }

    if (item.transmissionType.toString() == 'MANUAL') {
      this.form.get('transmissionType')?.setValue('2');
    }

    if (item.vehicleType.toString() == 'CAR') {
      this.form.get('vehicleType')?.setValue('1');
    }

    if (item.vehicleType.toString() == 'MOTOCYCLE') {
      this.form.get('vehicleType')?.setValue('2');
    }
  }

  private cleanMessage() {
    this.message.sucess = '';

    this.message.error = '';
  }
}