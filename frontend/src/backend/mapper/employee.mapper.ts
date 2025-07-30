import { FormGroup } from '@angular/forms';
import { EmployeeType } from '../enum/employee_type';
import { EmployeeRequestDTO } from '../../app/service/employee/employee.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class EmployeeMapper {
  toEmployeeDTO(form: FormGroup) {
    let select: EmployeeType = EmployeeType.MANAGER;

    if (form.get('employeeType')?.value == 2) {
      select = EmployeeType.SUBMANAGER;
    }

    if (form.get('employeeType')?.value == 3) {
      select = EmployeeType.SALER;
    }

    const dto: EmployeeRequestDTO = {
      birthDate: form.get('birthDate')?.value,
      commission: new Number(form.get('commission')?.value).toFixed(2),
      email: form.get('email')?.value,
      employeeType: select,
      matriculation: form.get('matriculation')?.value,
      name: form.get('name')?.value,
      phone: form.get('phone')?.value,
    };

    return dto;
  }
}
