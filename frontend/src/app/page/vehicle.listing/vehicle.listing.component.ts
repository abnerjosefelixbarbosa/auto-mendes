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
import { messages } from '../../../utils/message';

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
  //private employeeMapper = inject(EmployeeMapper);

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      id: [''],
      nameModel: ['', [Validators.required, Validators.maxLength(20)]],
      plate: [
        '',
        [Validators.required, Validators.email, Validators.maxLength(20)],
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

  private replace(item: VehicleResponseDTO) {
    this.form.get('id')?.setValue(item.id);
    this.form.get('nameModel')?.setValue(item.modelName);
    this.form.get('plate')?.setValue(item.plate);

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

    console.log(this.form.value);
  }

  private cleanMessage() {
    this.message.sucess = '';

    this.message.error = '';
  }
}
