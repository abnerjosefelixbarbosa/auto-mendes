import { Sale } from "./sale"

export interface Customer {
    id: string,
    document: string,
    name: string,
    email: string,
    phone: string,
    customerType: CustomerType,
    sales: Sale[]
}