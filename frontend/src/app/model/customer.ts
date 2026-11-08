import { EmployeeStatus } from "../enum/employee-status";
import { EmployeeType } from "../enum/employee-type";
import { Sale } from "./sale";

export interface Customer {
    id: string | null;
    name: string | null;
    matriculation: string | null;
    email: string | null;
    phone: string | null;
    birthDate: string | null;
    cpf: string | null;
    salary: number | null;
    commission: number | null;
    employeeStatus: EmployeeStatus | null;
    employeeType: EmployeeType | null;
    sales: Sale[] | null;
}
