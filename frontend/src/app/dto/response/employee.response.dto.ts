import { EmployeeType } from "../../enum/employee.type";

export interface EmployeeResponseDTO {
  id: string;
  name: string;
  email: string;
  matriculation: string;
  phone: string;
  birthDate: Date;
  employeeType: EmployeeType;
  commission: number;
}