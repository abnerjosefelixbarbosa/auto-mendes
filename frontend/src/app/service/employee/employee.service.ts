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

    /*
    return fetch(`${urlBase.dev}/api/employees/register-employee`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(dto),
    })
      .then((response) => response.json())
      .then((value) => {
        const dto: EmployeeResponseDTO = { ...value };
        return dto;
      });
    */
  }

  updateEmployeeById(id: string, dto: EmployeeRequestDTO) {
    this.employeeValidation.validateEmployee(dto);

    return firstValueFrom(
      this.http.put<EmployeeResponseDTO>(
        `${urlBase.dev}/api/employees/update-employee-by-id?id=${id}`,
        dto
      )
    );

    /*
    return fetch(
      `${urlBase.dev}/api/employees/update-employee-by-id?id=${id}`,
      {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(dto),
      }
    )
      .then((response) => response.json())
      .then((value) => {
        const dto: EmployeeResponseDTO = { ...value };
        return dto;
      });
    */
  }

  listEmployees() {
    return firstValueFrom(
      this.http.get<EmployeeResponseDTO[]>(`${urlBase.dev}/api/employees/list-employees`)
    );

    /*
    return fetch(`${urlBase.dev}/api/employees/list-employees`, {
      method: 'GET',
    })
      .then((response) => response.json())
      .then((value) => {
        const dtos: EmployeeResponseDTO[] = [];
        dtos.push(...value);
        return dtos;
      });
    */
  }

  listEmployeeById(id: string) {
    return firstValueFrom(
      this.http.get<EmployeeResponseDTO>(`${urlBase.dev}/list-employee-by-id?id=${id}`)
    );
  }
}
