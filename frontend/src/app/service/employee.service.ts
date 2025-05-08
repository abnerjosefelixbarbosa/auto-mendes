import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { firstValueFrom } from 'rxjs';
import { EmployeeType } from '../utils/employee.type';

export interface EmployeeRequestDTO {
  name: string;
  email: string;
  matriculation: string;
  phone: string;
  birthDate: Date;
  employeeType: EmployeeType;
  commission: number | null;
}

export interface EmployeeResponseDTO {
  id: string;
  name: string;
  email: string;
  matriculation: string;
  phone: string;
  birthDate: Date;
  employeeType: EmployeeType;
  commission: number;
}

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private url = 'http://localhost:8080/api/employees';

  constructor(private http: HttpClient) {}

  registreEmployee(data: EmployeeRequestDTO) {
    this.validadeEmployee(data);

    return firstValueFrom(
      this.http.post<EmployeeResponseDTO>(`${this.url}/register-employee`, data)
    );
  }

  listEmployee() {
    return firstValueFrom(this.http.get<any>(`${this.url}/list-employee`)).then(
      (value) => {
        const dtos = new Array<EmployeeResponseDTO>();
        const content = value.content;

        dtos.push(...content);

        return dtos;
      }
    );
  }

  listEmployeeByType(type: EmployeeType) {
    return firstValueFrom(
      this.http.get<any>(
        `${this.url}/list-employee-by-type?type=${type.toString()}`
      )
    ).then((value) => {
      const dtos = new Array<EmployeeResponseDTO>();
      const content = value.content;

      dtos.push(...content);

      return dtos;
    });
  }

  updateEmployeeById(id: string, data: EmployeeRequestDTO) {
    this.validadeEmployee(data);

    return firstValueFrom(
      this.http.put<EmployeeResponseDTO>(
        `${this.url}/update-employee-by-id?id=${id}`,
        data
      )
    );
  }

  private validadeEmployee(data: EmployeeRequestDTO) {
    if (data.employeeType.toString() == 'SALER' && data.commission == 0) {
      throw new Error('Comissão invalida.');
    }
  }
}
