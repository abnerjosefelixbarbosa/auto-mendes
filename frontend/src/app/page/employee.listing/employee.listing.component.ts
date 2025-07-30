import { Component, inject, OnInit } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import {
  EmployeeResponseDTO,
  EmployeeService,
} from '../../service/employee/employee.service';
import { DatePipe } from '@angular/common';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';
import { PhonePipe } from '../../pipe/phone/phone.pipe';
import { messages } from '../../../backend/utils/message';
import { EmployeeMapper } from '../../../backend/mapper/employee.mapper';

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
  form: FormGroup;
  message = messages;
  id: string = '';
  private employeeService = inject(EmployeeService);
  private employeeMapper = inject(EmployeeMapper);

  constructor(private formBuilder: FormBuilder, private datePipe: DatePipe) {
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
  }

  ngOnInit() {
    this.cleanMessage();

    this.listEmployee();
  }

  listEmployee() {
    this.employeeService
      .listEmployees()
      .then((values) => (this.items = values));
  }

  update(item: EmployeeResponseDTO) {
    this.cleanMessage();

    this.replace(item);
  }

  confirm() {
    this.cleanMessage();

    const id: string = this.form.get('id')?.value;

    const dto = this.employeeMapper.toEmployeeDTO(this.form);

    try {
      this.employeeService
        .updateEmployeeById(id!, dto)
        .then(() => {
          this.message.sucess = 'Funcionário atualizado.';

          setTimeout(() => {
            location.reload();
          }, 2000);
        })
        .catch((e) => (this.message.error = e.error.message));
    } catch (e: any) {
      this.message.error = e.message;
    }
  }

  private replace(item: EmployeeResponseDTO) {
    const [year, month, day] = item.birthDate.toString().split('-').map(Number);
    const date = new Date(year, month - 1, day);

    const dateFormated = this.formatDate(date);

    this.form.get('id')?.setValue(item.id);
    this.form.get('name')?.setValue(item.name);
    this.form.get('email')?.setValue(item.email);
    this.form.get('matriculation')?.setValue(item.matriculation);
    this.form.get('phone')?.setValue(item.phone);
    this.form.get('birthDate')?.setValue(dateFormated);
    this.form.get('commission')?.setValue(item.commission);

    if (item.employeeType.toString() == 'MANAGER') {
      this.form.get('employeeType')?.setValue('1');
    }

    if (item.employeeType.toString() == 'SUBMANAGER') {
      this.form.get('employeeType')?.setValue('2');
    }

    if (item.employeeType.toString() == 'SALER') {
      this.form.get('employeeType')?.setValue('3');
    }
  }

  private formatDate(date: Date) {
    return this.datePipe.transform(date, 'yyyy-MM-dd');
  }

  private cleanMessage() {
    this.message.sucess = '';

    this.message.error = '';
  }
}
