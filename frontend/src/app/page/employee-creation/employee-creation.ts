import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { EmployeeService } from '../../service/employee-service';

@Component({
  selector: 'app-employee-creation',
  standalone: true,
  imports: [],
  styleUrl: './employee-creation.css',
  templateUrl: './employee-creation.html',
})
export class EmployeeCreation {
  private employeeService: EmployeeService = inject(EmployeeService);

  constructor() {}


  createEmployee() {
    
  }
}
