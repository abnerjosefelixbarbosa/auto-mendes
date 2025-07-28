import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { urlBase } from '../../../utils/url';
import { TransmissionType } from '../../../enum/transmission_type';
import { VehicleType } from '../../../enum/vehicle_type';

export interface VehicleRequestDTO {
  plate: string | null;
  transmissionType: TransmissionType;
  price: string;
  modelName: string;
  vehicleType: VehicleType;
}

export interface VehicleResponseDTO {
  id: string;
  plate: string | null;
  transmissionType: TransmissionType;
  price: string;
  vehicleType: VehicleType;
  modelName: string;
}

@Injectable({
  providedIn: 'root',
})
export class VehicleService {
  constructor(private http: HttpClient) {}

  registerVehicle(vehicleRequestDTO: VehicleRequestDTO) {
    return firstValueFrom(
      this.http.post<VehicleResponseDTO>(
        `${urlBase.dev}/api/vehicles/register-vehicle`,
        vehicleRequestDTO
      )
    );
  }

  updateVehicleById(id: string, vehicleRequestDTO: VehicleRequestDTO) {
    return firstValueFrom(
      this.http.put<VehicleResponseDTO>(
        `${urlBase.dev}/api/vehicles/update-vehicle-by-id?id=${id}`,
        vehicleRequestDTO
      )
    );
  }

  listVehicles() {
    return firstValueFrom(
      this.http.get<VehicleResponseDTO[]>(`${urlBase.dev}/api/vehicles/list-vehicles`)
    );
  }
}
