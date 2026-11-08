import { PaymentType } from "../enum/payment-type";
import { Customer } from "./customer";
import { Employee } from "./employee";
import { Item } from "./item";

export interface Sale {
    id: string | null;
    saleDate: string | null;
    paymentType: PaymentType | null;
    totalValue: number | null;
    employee: Employee | null;
    customer: Customer | null;
    items: Item[] | null;
}
