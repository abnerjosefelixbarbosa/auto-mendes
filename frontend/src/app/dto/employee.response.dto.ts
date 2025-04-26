import { EmployeeType } from "../utils/employee.type";

export interface EmployeeResponseDTO {
  id: string;
  name: string;
  email: string;
  matriculation: string;
  phone: string;
  birthDate: Date;
  commission: number;
}