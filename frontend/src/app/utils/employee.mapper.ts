import { FormGroup } from '@angular/forms';
import { EmployeeRequestDTO } from '../service/employee.service';
import { EmployeeType } from './employee.type';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeMapper {

  constructor() {}

  toEmployeeRequestDTO(form: FormGroup) {
    let data: EmployeeRequestDTO;

    if (form.get('employeeType')?.value == '1') {
      data = {
        ...form.value,
        employeeType: EmployeeType.MANAGER.toString()
      };
    }

    if (form.get('employeeType')?.value == '2') {
      data = {
        ...form.value,
        employeeType: EmployeeType.ASSISTANT_MANAGER
      };
    }

    if (form.get('employeeType')?.value == '3') {
      data = {
        ...form.value,
        employeeType: EmployeeType.SALER
      };
    }

    return data!;
  }
}