import { Injectable } from '@angular/core';
import { EmployeeRequestDTO } from '../service/employee/employee.service';

@Injectable({
  providedIn: 'root',
})
export class EmployeeValidation {
  
  constructor() {}

  validadeEmployee(employeeRequestDTO: EmployeeRequestDTO) {
    if (
      employeeRequestDTO.employeeType == 'SALER' &&
      employeeRequestDTO.commission == 0
    ) {
      throw new Error('Comissão invalida.');
    }
  }
}