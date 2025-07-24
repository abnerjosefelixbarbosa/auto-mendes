import { Injectable } from "@angular/core";
import { FormGroup } from "@angular/forms";
import { EmployeeRequestDTO } from "../app/service/employee/employee.service";
import { EmployeeType } from "../enum/employee_type";
import { VehicleType } from "../enum/vehicle_type";
import { VehicleRequestDTO } from "../app/service/vehicle/vehicle.service";
import { TransmissionType } from "../enum/transmission_type";




@Injectable({
  providedIn: 'root',
})
export class VehicleMapper {
  toVehicleDTO(form: FormGroup) {
    let vehicleSelect: VehicleType = VehicleType.CAR;
    let transmissionType: TransmissionType = TransmissionType.AUTO;
    let plate: string | null = null;

    if (form.get('vehicleType')?.value == 2) {
      vehicleSelect = VehicleType.MOTOCYCLE;
    }

    if (form.get('transmissionType')?.value == 2) {
      transmissionType = TransmissionType.MANUAL;
    }

    if (form.get('plate')?.value != '') {
      plate = form.get('plate')?.value;
    }

    const dto: VehicleRequestDTO = {
      modelName: form.get('modelName')?.value,
      plate: plate,
      price: Number(form.get('price')?.value).toFixed(2),
      transmissionType: transmissionType,
      vehicleType: vehicleSelect
    };

    return dto;
  }

}