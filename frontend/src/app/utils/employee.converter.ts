import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { EmployeeRequestDTO } from '../dto/employee.request.dto';
import { EmployeeType } from './employee.type';

@Injectable({
  providedIn: 'root',
})
export class EmployeeConverter {
  constructor() {}

  convertFormToEmployeeRequestDTO(form: FormGroup) {
    let dto: EmployeeRequestDTO | null = null;

    if (form.get('employeeType')?.value == 1) {
      dto = {
        birthDate: new Date(form.get('birthDate')?.value),
        commission: form.get('commission')?.value,
        email: form.get('email')?.value,
        employeeType: EmployeeType.MANAGER,
        matriculation: form.get('matriculation')?.value,
        name: form.get('name')?.value,
        phone: form.get('phone')?.value,
      };
    }

    if (form.get('employeeType')?.value == 2) {
      dto = {
        birthDate: new Date(form.get('birthDate')?.value),
        commission: form.get('commission')?.value,
        email: form.get('email')?.value,
        employeeType: EmployeeType.ASSISTANT_MANAGER,
        matriculation: form.get('matriculation')?.value,
        name: form.get('name')?.value,
        phone: form.get('phone')?.value,
      };
    }

    if (form.get('employeeType')?.value == 3) {
      dto = {
        birthDate: new Date(form.get('birthDate')?.value),
        commission: form.get('commission')?.value,
        email: form.get('email')?.value,
        employeeType: EmployeeType.SALER,
        matriculation: form.get('matriculation')?.value,
        name: form.get('name')?.value,
        phone: form.get('phone')?.value,
      };
    }

    return dto!;
  }
}
