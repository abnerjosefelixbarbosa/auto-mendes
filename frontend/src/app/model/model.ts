import { Brand } from "./brand";
import { Vehicle } from "./vehicle";

export interface Model {
    id: string,
    name: string,
    brand: Brand,
    vehicles : Vehicle[] 
}