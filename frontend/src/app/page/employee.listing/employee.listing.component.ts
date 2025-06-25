import { Component, inject, OnInit } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import {
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

@Component({
  selector: 'app-employee-listing',
  imports: [
    NavbarComponent,
    ReactiveFormsModule,
    DatePipe,
    PhonePipe,
    NgxMaskDirective,
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
  type: EmployeeType = EmployeeType.MANAGER;
  form: FormGroup;
  message = messages;
  private employeeService = inject(EmployeeService);

  constructor(private formBuilder: FormBuilder, private datePipe: DatePipe) {
    this.select.valueChanges.subscribe((value) => {
      const option = value!;

      if (option === '1') {
        this.type = EmployeeType.MANAGER;
      }

      if (option === '2') {
        this.type = EmployeeType.SUBMANAGER;
      }

      if (option === '3') {
        this.type = EmployeeType.SALER;
      }
    });

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
      employeeType: [''],
      commission: ['', []],
    });
  }

  ngOnInit(): void {
    this.listEmployee();
  }

  listEmployee() {
    this.employeeService
      .listEmployee()
      .then((values) => (this.items = values))
      .catch((e) => console.log(e));
  }

  update(item: EmployeeResponseDTO) {
    this.cleanMessage();

    this.replace(item);
  }

  confirm() {
    try {
      this.cleanMessage();

      if (this.form.valid) {
        
      } else {
        this.form.markAllAsTouched();
      }
    } catch (e: any) {
      this.message.error = e.message;
    }
  }

  private replace(item: EmployeeResponseDTO) {
    const date = new Date(item.birthDate);

    const dateFormated = this.formatDate(date);

    this.form.get('id')?.setValue(item.id);
    this.form.get('name')?.setValue(item.name);
    this.form.get('email')?.setValue(item.email);
    this.form.get('matriculation')?.setValue(item.matriculation);
    this.form.get('phone')?.setValue(item.phone);
    this.form.get('birthDate')?.setValue(dateFormated);
    this.form.get('employeeType')?.setValue(item.employeeType);
    this.form.get('commission')?.setValue(item.commission);
  }

  private formatDate(date: Date) {
    return this.datePipe.transform(date, 'yyyy-MM-dd');
  }

  private cleanMessage() {
    this.message.sucess = '';
    this.message.error = '';
  }
}
