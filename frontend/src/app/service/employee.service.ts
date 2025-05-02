import { Injectable, inject } from '@angular/core';import { EmployeeResponseDTO } from '../dto/employee.response.dto';
import { FormGroup } from '@angular/forms';
import { EmployeeConverter } from '../utils/employee.converter';
import { HttpClient } from '@angular/common/http';
import { firstValueFrom } from 'rxjs';
import { EmployeeType } from '../utils/employee.type'
import { EmployeeRequestDTO } from '../dto/employee.request.dto';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  employeeConverter = inject(EmployeeConverter);
  private url = 'http://localhost:8080/api/employees'

  constructor(private http: HttpClient) { }  

  registreEmployee(form: FormGroup) {
    const request = this.employeeConverter.convertFormToEmployeeRequestDTO(form);

    return firstValueFrom(this.http.post<EmployeeResponseDTO>(`${this.url}/register-employee`, request));
  }

  listEmployee() {
    return firstValueFrom(this.http.get<any>(`${this.url}/list-employee`))
    .then((value) => {
      const dtos = new Array<EmployeeResponseDTO>();
      const content = value.content;

      dtos.push(...content)

      return dtos;
    });
  }

  listEmployeeByType(type: EmployeeType) {
    return firstValueFrom(this.http.get<any>(`${this.url}/list-employee-by-type?type=${type.toString()}`))
    .then((value) => {
      const dtos = new Array<EmployeeResponseDTO>();
      const content = value.content;

      dtos.push(...content)

      return dtos;
    });
  }

  updateEmployeeById(id: string, data: EmployeeRequestDTO) {
    return firstValueFrom(this.http.put<EmployeeResponseDTO>(`${this.url}/update-employee-by-id?id=${id}`, data));
  }
}