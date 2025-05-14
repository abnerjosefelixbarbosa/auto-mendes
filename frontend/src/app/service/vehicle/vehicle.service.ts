import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { VehicleType } from '../../utils/vehicle.type';
import { TransmissionType } from '../../utils/transmission.type';
import { firstValueFrom } from 'rxjs';

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
  private url = 'http://localhost:8080/api/brands';

  constructor(private http: HttpClient) {}

  registerModel(vehicleRequestDTO: VehicleRequestDTO) {
    return firstValueFrom(
      this.http.post<VehicleResponseDTO>(
        `${this.url}/register-vehicle`,
        vehicleRequestDTO
      )
    );
  }

  updateModelById(id: string, vehicleRequestDTO: VehicleRequestDTO) {
    return firstValueFrom(
      this.http.put<VehicleResponseDTO>(
        `${this.url}/update-vehicle-by-id?id=${id}`,
        vehicleRequestDTO
      )
    );
  }

  listModel() {
    return firstValueFrom(this.http.get<any>(`${this.url}/list-vehicle`)).then(
      (value) => {
        const dtos = new Array<VehicleResponseDTO>();
        const content = value.content;

        dtos.push(...content);

        return dtos;
      }
    );
  }

  listModelByName(model: string) {
    return firstValueFrom(
      this.http.get<any>(`${this.url}/list-vehicle-by-model?model=${model}`)
    ).then((value) => {
      const dtos = new Array<VehicleResponseDTO>();
      const content = value.content;

      dtos.push(...content);

      return dtos;
    });
  }
}
