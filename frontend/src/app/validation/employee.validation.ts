import { Injectable } from '@angular/core';
import { EmployeeRequestDTO } from '../service/employee/employee.service';

@Injectable({
  providedIn: 'root',
})
export class EmployeeValidation {
  validateEmployee(dto: EmployeeRequestDTO) {
    if (dto.employeeType == 2) {
      if (dto.commission === 0) {
        throw new Error('Comissão não deve ser 0.');
      }
    } else {
      if (dto.commission !== 0) {
				throw new Error("Comissão deve ser 0.");
			}
    }
  }
}
