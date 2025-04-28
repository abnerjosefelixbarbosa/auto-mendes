import { Component, inject, OnInit } from '@angular/core';
import { NavbarComponent } from "../../components/navbar/navbar.component";
import { EmployeeService } from './../../service/employee.service';
import { EmployeeResponseDTO } from '../../dto/employee.response.dto';
import { DatePipe } from '@angular/common';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { EmployeeType } from '../../utils/employee.type';

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
  type: EmployeeType = EmployeeType.MANAGER; 

  constructor() {
    this.select.valueChanges.subscribe(value => {
      const option = value!

      if (option === '1') {
        this.type = EmployeeType.MANAGER
      }

      if (option === '2') {
        this.type = EmployeeType.ASSISTANT_MANAGER
      }

      if (option === '3') {
        this.type = EmployeeType.SALER
      }
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
    this.employeeService.listEmployeeByType(this.type)
    .then((values) =>  this.items = values)
    .catch((e) => console.log(e))
  }
}
