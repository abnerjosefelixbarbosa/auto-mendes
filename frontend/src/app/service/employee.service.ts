import { Injectable, inject } from '@angular/core';import { EmployeeResponseDTO } from '../dto/employee.response.dto';
import { FormGroup } from '@angular/forms';
import { EmployeeConverter } from '../utils/employee.converter';
import { HttpClient } from '@angular/common/http';
import { firstValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  employeeMapper = inject(EmployeeConverter);
  private url = 'http://localhost:8080/api/employees'

  constructor(private http: HttpClient) { }  

  registreEmployee(form: FormGroup) {
    const request = this.employeeMapper.convertFormToEmployeeRequestDTO(form);

    return firstValueFrom(this.http.post<EmployeeResponseDTO>(`${this.url}/register-employee`, request));
  }

  listEmployee() {
    return firstValueFrom(this.http.get<any>(`${this.url}/list-employee`))
    .then((value) => {
      const dtos = new Array<EmployeeResponseDTO>();

      dtos.push( ...value.content )

      return dtos;
    });
  }
}