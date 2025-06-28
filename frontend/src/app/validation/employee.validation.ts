import { Injectable } from '@angular/core';
import { EmployeeRequestDTO } from '../service/employee/employee.service';

@Injectable({
  providedIn: 'root',
})
export class EmployeeValidation {
  validateEmployee(dto: EmployeeRequestDTO) {
    const commission = new Number(dto.commission).valueOf();

    if (dto.employeeType == 2) {
      if (commission === 0) {
        throw new Error('Comissão não deve ser 0.');
      }
    }
  }
}
