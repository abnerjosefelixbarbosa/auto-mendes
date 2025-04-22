import { TransmissionType } from '../../enum/transmission.type';
import { VehicleType } from '../../enum/vehicle.type';

export interface VehicleRequestDTO {
  plate: string;
  transmissionType: TransmissionType;
  price: number;
  modelName: string;
  vehicleType: VehicleType;
}