import { Sale } from './sale';
import { SaleVehicleId } from './sale_vehicle_id';
import { Vehicle } from './vehicle';

export interface SaleVehicle {
  saleVehicleId: SaleVehicleId;
  quantity: number;
  sale: Sale;
  vehicle: Vehicle;
}