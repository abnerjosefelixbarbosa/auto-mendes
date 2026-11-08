import { TransmissionType } from "../enum/transmission-type";
import { VehicleStatus } from "../enum/vehicle-status";
import { Item } from "./item";
import { Model } from "./model";

export interface Vehicle {
    id: string | null;
    plate: string | null;
    transmissionType: TransmissionType | null;
    vehicleStatus: VehicleStatus | null;
    color: string | null;
    price: number | null;
    model: Model | null;
    items: Item[] | null;
}
