import { Injectable } from '@angular/core';
import { EmployeeRequestDTO } from './../../dto/request/employee.request.dto';
import { EmployeeResponseDTO } from './../../dto/response/employee.response.dto';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor() { }

  registreEmployee(dto: EmployeeRequestDTO): Promise<EmployeeResponseDTO | null>  {
    return new Promise((resolve, reject) => {
      resolve(null);
    });
  }
}
