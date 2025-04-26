import { Component, inject, OnInit } from '@angular/core';
import { NavbarComponent } from "../../components/navbar/navbar.component";
import { EmployeeService } from './../../service/employee.service';

@Component({
  selector: 'app-employee-listing',
  imports: [NavbarComponent],
  templateUrl: './employee-listing.component.html',
  styleUrl: './employee-listing.component.css'
})
export class EmployeeListingComponent implements OnInit {
  employeeService = inject(EmployeeService);

  constructor() {}

  ngOnInit(): void {
    this.listEmployee();
  }

  listEmployee() {
    this.employeeService.listEmployee()
    .then((value) => console.log(value))
    .catch((e) => console.log(e))
  }
}
