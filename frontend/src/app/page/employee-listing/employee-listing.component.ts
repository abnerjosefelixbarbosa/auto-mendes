import { Component, inject, OnInit } from '@angular/core';
import { NavbarComponent } from "../../components/navbar/navbar.component";
import { EmployeeService } from './../../service/employee.service';
import { EmployeeResponseDTO } from '../../dto/employee.response.dto';

interface Item {
  name: string,
  email: string,
  matriculation: string,
  phone: string,
  birthDate: string,
  commission: number
}

@Component({
  selector: 'app-employee-listing',
  imports: [NavbarComponent],
  templateUrl: './employee-listing.component.html',
  styleUrl: './employee-listing.component.css'
})
export class EmployeeListingComponent implements OnInit {
  items = new Array<Item>();
  employeeService = inject(EmployeeService);

  constructor() {}

  ngOnInit(): void {
    this.listEmployee();
  }

  listEmployee() {
    this.employeeService.listEmployee()
    .then((value) => { 
      //this.list = value
      value.forEach((dto) => {
        this.items.push({ 
          birthDate: ``,
          commission: dto.commission,
          email: dto.email,
          matriculation: dto.matriculation,
          name: dto.name,
          phone: dto.phone
        })
      });
    })
    .catch((e) => console.log(e))
  }
}
