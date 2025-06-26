import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { firstValueFrom } from 'rxjs';
import { urlBase } from '../../utils/url';
import { EmployeeType } from '../../enum/employee_type';

export interface EmployeeRequestDTO {
  name: string;
  email: string;
  matriculation: string;
  phone: string;
  birthDate: Date;
  employeeType: EmployeeType;
  commission: number;
}

export interface EmployeeResponseDTO {
  id: string;
  name: string;
  email: string;
  matriculation: string;
  phone: string;
  birthDate: Date;
  employeeType: EmployeeType;
  commission: number | null;
}

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  constructor(private http: HttpClient) {}

  registreEmployee(employeeRequestDTO: EmployeeRequestDTO) {
    return firstValueFrom(
      this.http.post<EmployeeResponseDTO>(
        `${urlBase.dev}/api/employees/register-employee`,
        employeeRequestDTO
      )
    );
  }

  updateEmployeeById(id: string, employeeRequestDTO: EmployeeRequestDTO) {
    return firstValueFrom(
      this.http.put<EmployeeResponseDTO>(
        `${urlBase.dev}/api/employees/update-employee-by-id?id=${id}`,
        employeeRequestDTO
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

      return dtos;
    });
  }
}
