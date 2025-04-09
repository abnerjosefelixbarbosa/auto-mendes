import { TransmissionType } from "../../enum/TransmissionType";

export interface VehicleResponseDTO {
    id: string,
    plate: string,
    transmissionType: TransmissionType,
    price: number,
    modelName: string
}