import { TransmissionType } from '../../enums/transmission_type';
import { VehicleType } from '../../enums/vehicle_type';

export interface VehicleRequestDTO {
  plate: string;
  transmissionType: TransmissionType;
  price: number;
  modelName: string;
  vehicleType: VehicleType;
}