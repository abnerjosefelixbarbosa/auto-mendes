import { Component, inject, OnInit } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import {
  EmployeeRequestDTO,
  EmployeeResponseDTO,
  EmployeeService,
} from '../../service/employee/employee.service';
import { DatePipe } from '@angular/common';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';
import { PhonePipe } from '../../pipe/phone/phone.pipe';
import { messages } from '../../utils/message';
import { EmployeeType } from '../../enum/employee_type';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-listing',
  imports: [
    NavbarComponent,
    ReactiveFormsModule,
    DatePipe,
    PhonePipe
  ],
  templateUrl: './employee.listing.component.html',
  styleUrl: './employee.listing.component.css',
  standalone: true,
  providers: [DatePipe, provideNgxMask()],
})
export class EmployeeListingComponent implements OnInit {
  items = new Array<EmployeeResponseDTO>();
  item: EmployeeResponseDTO | null = null;
  select = new FormControl('1');
  employeeType: EmployeeType = EmployeeType.MANAGER;
  form: FormGroup;
  message = messages;
  id: string = '';
  private employeeService = inject(EmployeeService);

  constructor(private router: Router, private formBuilder: FormBuilder, private datePipe: DatePipe) {
    this.form = this.formBuilder.group({
      id: [''],
      name: ['', [Validators.required, Validators.maxLength(100)]],
      email: [
        '',
        [Validators.required, Validators.email, Validators.maxLength(100)],
      ],
      matriculation: [
        '',
        [
          Validators.required,
          Validators.minLength(10),
          Validators.maxLength(10),
        ],
      ],
      phone: ['', [Validators.required, Validators.maxLength(30)]],
      birthDate: ['', [Validators.required]],
      employeeType: ['', [Validators.required]],
      commission: ['', []],
    });

    this.form.get('employeeType')?.valueChanges.subscribe((value) => {
      const option = value;

      if (option === '1') {
        this.employeeType = EmployeeType.MANAGER;
      }

      if (option === '2') {
        this.employeeType = EmployeeType.SUBMANAGER;
      }

      if (option === '3') {
        this.employeeType = EmployeeType.SALER;
      }
    });
  }

  ngOnInit(): void {
    this.listEmployee();
  }

  listEmployee() {
    this.employeeService
      .listEmployees()
      .then((values) => (this.items = values))
      .catch((e) => console.log(e));
  }

  update(item: EmployeeResponseDTO) {
    this.router.navigate(['/employee-update-by-id', item.id]);
  }

  private cleanMessage() {
    this.message.sucess = '';
    this.message.error = '';
  }
}
