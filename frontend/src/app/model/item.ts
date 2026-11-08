import { Sale } from "./sale";
import { Vehicle } from "./vehicle";

export interface Item {
    id: string | null;
    sale: Sale | null;
    vehicle: Vehicle | null;
}
