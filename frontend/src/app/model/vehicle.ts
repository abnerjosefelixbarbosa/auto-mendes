import { TransmissionType } from "../enum/transmission_type";
import { VehicleType } from "../enum/vehicle_type";

export interface Vehicle {
    id: string,
    plate: string,
    price: number,
    model: Model,
    transmissionType: TransmissionType,
    vehicleType: VehicleType,
    saleVehicles: Sale[] 
} 