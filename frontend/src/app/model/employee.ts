import { EmployeeType } from "../enum/employee_type";
import { Sale } from "./sale";

export interface Employee {
    id: string,
    name: string,
    email: string,
    registration: string,
    phone: String,
    birthDate: Date,
    commission: number,
    employeeType: EmployeeType,
    sales: Sale[]
}