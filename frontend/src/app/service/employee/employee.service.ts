import { inject, Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
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

    this.http.put<EmployeeResponseDTO>(
      `${urlBase.dev}/api/employees/update-employee-by-id`,
      dto,
      {
        params: new HttpParams().set('id', `${id}`),
      }
    ).subscribe({
      next(value) {
        console.log(value)
      },
      error(err) {
        console.error(err)
      },
    });
  }

  listEmployees() {
    return firstValueFrom(
      this.http.get<EmployeeResponseDTO[]>(
        `${urlBase.dev}/api/employees/list-employees`
      )
    );
  }

  getEmployeeById(id: string) {
    return firstValueFrom(
      this.http.get<EmployeeResponseDTO>(
        `${urlBase.dev}/api/employees/get-employee-by-id?id=${id}`
      )
    );
  }
}
