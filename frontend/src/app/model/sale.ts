import { PaymenType } from "../enum/paymen_type"
import { Customer } from "./customer"
import { Employee } from "./employee"

export interface Sale {
    id: string,
    saleDateTime: Date,
    total: number,
    customer: Customer,
    employee: Employee,
    paymentType: PaymenType,
    saleVehicles: []
}