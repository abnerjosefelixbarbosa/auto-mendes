import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { firstValueFrom } from 'rxjs';
import { urlBase } from '../../utils/url';
import { EmployeeType } from '../../enum/employee_type';
import { EmployeeValidation } from '../../validation/employee.validation';

export interface EmployeeRequestDTO {
  name: string;
  email: string;
  matriculation: string;
  phone: string;
  birthDate: Date;
  employeeType: EmployeeType;
  commission: string | null;
}

export interface EmployeeResponseDTO {
  id: string;
  name: string;
  email: string;
  matriculation: string;
  phone: string;
  birthDate: Date;
  employeeType: EmployeeType;
  commission: string | null;
}

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private employeeValidation = inject(EmployeeValidation);

  constructor(private http: HttpClient) {}

  registreEmployee(dto: EmployeeRequestDTO) {
    this.employeeValidation.validateEmployee(dto);

    return firstValueFrom(
      this.http.post<EmployeeResponseDTO>(
        `${urlBase.dev}/api/employees/register-employee`,
        dto
      )
    );
  }

  updateEmployeeById(id: string, dto: EmployeeRequestDTO) {
    this.employeeValidation.validateEmployee(dto);
    
    return firstValueFrom(
      this.http.put<EmployeeResponseDTO>(
        `${urlBase.dev}/api/employees/update-employee-by-id?id=${id}`,
        dto
      )
    );
  }

  listEmployee() {
    return firstValueFrom(
      this.http.get<any>(`${urlBase.dev}/api/employees/list-employees`)
    ).then((value) => {
      const dtos: EmployeeResponseDTO[] = [];
      const content = value.content;

      dtos.push(...content);

      return dtos.map((value) => {
        value.commission = new Number(value.commission).toFixed(2);
        return value;
      });
    });
  }
}
