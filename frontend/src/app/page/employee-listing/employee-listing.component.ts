import { Component, inject, OnInit } from '@angular/core';
import { NavbarComponent } from "../../components/navbar/navbar.component";
import { EmployeeService } from './../../service/employee.service';
import { EmployeeResponseDTO } from '../../dto/employee.response.dto';
import { DatePipe } from '@angular/common';
import { FormControl, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-employee-listing',
  imports: [NavbarComponent, DatePipe, ReactiveFormsModule],
  templateUrl: './employee-listing.component.html',
  styleUrl: './employee-listing.component.css'
})
export class EmployeeListingComponent implements OnInit {
  items = new Array<EmployeeResponseDTO>();
  employeeService = inject(EmployeeService);
  select = new FormControl('1');
  employeeType = ''; 

  constructor() {
    this.select.valueChanges.subscribe(value => {
      this.employeeType = value!
    });
  }

  ngOnInit(): void {
    this.listEmployee();
  }

  listEmployee() {
    this.employeeService.listEmployee()
    .then((values) =>  this.items = values)
    .catch((e) => console.log(e))
  }

  listByTypeEmployee() {
    console.log(this.employeeType)
  }
}
