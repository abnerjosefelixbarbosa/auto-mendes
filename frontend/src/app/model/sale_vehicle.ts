import { Sale } from "./sale";
import { Vehicle } from "./vehicle";
import { PaymenType } from "../enum/paymen_type"

interface SaleVehicle {
    saleVehicleId: string, 
    quantity: number,
    sale: Sale,
    vehicle: Vehicle,
    paymentType: PaymenType 
}