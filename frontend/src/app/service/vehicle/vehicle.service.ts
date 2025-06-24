import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { urlBase } from '../../utils/url';
import { TransmissionType } from '../../enum/transmission_type';
import { VehicleType } from '../../enum/vehicle_type';

export interface VehicleRequestDTO {
  plate: string;
  transmissionType: TransmissionType;
  price: number;
  modelName: string;
  vehicleType: VehicleType;
}

export interface VehicleResponseDTO {
  id: string;
  plate: string;
  transmissionType: TransmissionType;
  price: number;
  vehicleType: VehicleType;
  modelName: string;
}

@Injectable({
  providedIn: 'root',
})
export class VehicleService {
  constructor(private http: HttpClient) {}

  registerModel(vehicleRequestDTO: VehicleRequestDTO) {
    return firstValueFrom(
      this.http.post<VehicleResponseDTO>(
        `${urlBase.dev}/api/vehicles/register-vehicle`,
        vehicleRequestDTO
      )
    );
  }

  updateModelById(id: string, vehicleRequestDTO: VehicleRequestDTO) {
    return firstValueFrom(
      this.http.put<VehicleResponseDTO>(
        `${urlBase.dev}/api/vehicles/update-vehicle-by-id?id=${id}`,
        vehicleRequestDTO
      )
    );
  }

  listModel() {
    return firstValueFrom(
      this.http.get<any>(`${urlBase.dev}/api/vehicles/list-vehicles`)
    ).then((value) => {
      const dtos = new Array<VehicleResponseDTO>();
      const content = value.content;

      dtos.push(...content);

      return dtos;
    });
  }
}
