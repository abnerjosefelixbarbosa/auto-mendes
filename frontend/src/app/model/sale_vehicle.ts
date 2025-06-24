import { Sale } from "./sale";
import { Vehicle } from "./vehicle";
import { PaymenType } from "../enum/paymen_type"

export interface SaleVehicle {
    saleId: string,
    vehicleId: string,
    quantity: number,
    sale: Sale,
    vehicle: Vehicle,
    paymentType: PaymenType 
}