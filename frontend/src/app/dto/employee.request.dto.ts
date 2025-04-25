import { EmployeeType } from '../utils/employee.type';

export interface EmployeeRequestDTO {
  name: string;
  email: string;
  matriculation: string;
  phone: string;
  birthDate: Date;
  employeeType: EmployeeType;
  commission: number;
}