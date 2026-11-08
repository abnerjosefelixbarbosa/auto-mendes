import { CustomerType } from "../enum/customer-type";
import { Sale } from "./sale";

export interface Employee {
    id: string | null;
    name: string | null;
    document: string | null;
    email: string | null;
    phone: string | null;
    customerType: CustomerType | null;
    sales: Sale[] | null;
}
