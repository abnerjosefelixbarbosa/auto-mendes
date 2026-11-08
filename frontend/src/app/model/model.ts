import { Brand } from "./brand";
import { Vehicle } from "./vehicle";

export interface Model {
    id: string | null;
    name: string | null;
    brand: Brand | null;
    vehicles: Vehicle[] | null;
}
