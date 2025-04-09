import { TransmissionType } from "../../enum/TransmissionType";
import { VehicleType } from "../../enum/VehicleType";

export interface VehicleRequestDTO {
    plate: string,
    transmissionType: TransmissionType,
    price: number,
    modelName: string,
    vehicleType: VehicleType
}