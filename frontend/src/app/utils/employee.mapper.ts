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

    if (form.get('employeeType')?.value == 1) {
      data = {
        birthDate: form.get('birthDate')?.value,
        commission: form.get('commission')?.value,
        email: form.get('email')?.value,
        employeeType: EmployeeType.MANAGER,
        matriculation: form.get('matriculation')?.value,
        name: form.get('name')?.value,
        phone: form.get('phone')?.value,
      };
    }

    if (form.get('employeeType')?.value == 2) {
      data = {
        birthDate: form.get('birthDate')?.value,
        commission: form.get('commission')?.value,
        email: form.get('email')?.value,
        employeeType: EmployeeType.ASSISTANT_MANAGER,
        matriculation: form.get('matriculation')?.value,
        name: form.get('name')?.value,
        phone: form.get('phone')?.value,
      };
    }

    if (form.get('employeeType')?.value == 3) {
      data = {
        birthDate: form.get('birthDate')?.value,
        commission: form.get('commission')?.value,
        email: form.get('email')?.value,
        employeeType: EmployeeType.SALER,
        matriculation: form.get('matriculation')?.value,
        name: form.get('name')?.value,
        phone: form.get('phone')?.value,
      };
    }

    return data!;
  }
}