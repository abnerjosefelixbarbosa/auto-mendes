import { Injectable } from '@angular/core';
import { EmployeeRequestDTO } from '../service/employee/employee.service';

@Injectable({
  providedIn: 'root',
})
export class EmployeeValidation {
  validateEmployee(dto: EmployeeRequestDTO) {
    const digits = dto.commission.toString().split('.');

    console.log(digits)

    if (dto.employeeType == 2) {
      if (dto.commission === 0) {
        throw new Error('Comissão não deve ser 0.');
      }

      if (/^\d+\.\d{2}$/.test(dto.commission.toString())) {
        throw new Error('Comissão deve ter 2 dígitos depois da vírgula.');
      }
    } else {
      if (dto.commission !== 0) {
				throw new Error("Comissão deve ser 0.");
			}
    }
  }
}
