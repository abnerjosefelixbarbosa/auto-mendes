import { Injectable, inject } from '@angular/core';import { EmployeeResponseDTO } from './../../dto/response/employee.response.dto';
import { FormGroup } from '@angular/forms';
import { EmployeeMapper } from '../../mapper/employee/employee.mapper';
import { HttpClient } from '@angular/common/http';
import { firstValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  employeeMapper = inject(EmployeeMapper);
  private url = 'http://localhost:8080/api/employees'

  constructor(private http: HttpClient) { }  

  registreEmployee(form: FormGroup) {
    const request = this.employeeMapper.toEmployeeRequestDTO(form);

    return firstValueFrom(this.http.post<EmployeeResponseDTO>(`${this.url}/register-employee`, request));
  }
}