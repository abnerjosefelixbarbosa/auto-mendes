import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
    private apiUrl = 'http://localhost:8080/employees';

    constructor(private http: HttpClient) {}

    registerEmployee(employee: Employee)  {
        return this.http.post<Employee>(this.apiUrl, employee);
    }
}
