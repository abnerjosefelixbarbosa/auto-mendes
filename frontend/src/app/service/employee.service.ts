import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { firstValueFrom } from 'rxjs';
import { EmployeeType } from '../utils/employee.type';
import { EmployeeValidation } from '../utils/employee.validation';

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
  commission: number | null;
}

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private url = 'http://localhost:8080/api/employees';
  private employeeValidation = inject(EmployeeValidation);

  constructor(private http: HttpClient) {}

  registreEmployee(employeeRequestDTO: EmployeeRequestDTO) {
    this.employeeValidation.validadeEmployee(employeeRequestDTO);

    return firstValueFrom(
      this.http.post<EmployeeResponseDTO>(`${this.url}/register-employee`, employeeRequestDTO)
    );
  }

  listEmployee() {
    return firstValueFrom(
      this.http.get<any>(`${this.url}/list-employee`)
    ).then(
      (value) => {
        const dtos = new Array<EmployeeResponseDTO>();
        const content = value.content;

        dtos.push(...content);

        return dtos;
      }
    ).catch(() => {
        const dtos = new Array<EmployeeResponseDTO>();

        return dtos;
    });
  }

  listEmployeeByType(employeeType: EmployeeType) {
    return firstValueFrom(
      this.http.get<any>(`${this.url}/list-employee-by-type?employeeType=${employeeType}`)
    )
      .then((value) => {
        const dtos = new Array<EmployeeResponseDTO>();
        const content = value.content;

        dtos.push(...content);

        return dtos;
      })
      .catch((e) => {
        const dtos = new Array<EmployeeResponseDTO>();

        console.log(e)

        return dtos;
      });
  }

  updateEmployeeById(id: string, employeeRequestDTO: EmployeeRequestDTO) {
    this.employeeValidation.validadeEmployee(employeeRequestDTO);

    return firstValueFrom(
      this.http.put<EmployeeResponseDTO>(
        `${this.url}/update-employee-by-id?id=${id}`,
        employeeRequestDTO
      )
    );
  }
}
