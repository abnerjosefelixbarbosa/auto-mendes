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
  imports: [NavbarComponent, ReactiveFormsModule, DatePipe, PhonePipe, NgxMaskDirective],
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

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private datePipe: DatePipe
  ) {
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
    this.cleanMessage();
    this.listEmployee();
  }

  listEmployee() {
    this.employeeService
      .listEmployees()
      .then((values) => (this.items = values));
  }

  update(item: EmployeeResponseDTO) {
    //this.router.navigate(['/employee-update-by-id', item.id]);
    this.cleanMessage();

    this.replace(item);
  }

  confirm() {
    try {
      this.cleanMessage();

      const id: string = this.form.get('id')?.value;

      const dto = this.transferEmployeeDTO(this.form);

      this.employeeService
        .updateEmployeeById(id!, dto)
        .then(() => (this.message.sucess = 'Funcionário atualizado.'))
        .catch((e) => (this.message.error = e.error.message));
    } catch (e: any) {
      this.message.error = e.message;
    }
  }

  private transferEmployeeDTO(form: FormGroup) {
    let select: EmployeeType = EmployeeType.MANAGER;

    if (form.get('employeeType')?.value === 0) {
      select = EmployeeType.MANAGER;
    }

    if (form.get('employeeType')?.value === 1) {
      select = EmployeeType.SUBMANAGER;
    }

    if (form.get('employeeType')?.value === 2) {
      select = EmployeeType.SALER;
    }

    const dto: EmployeeRequestDTO = {
      birthDate: form.get('birthDate')?.value,
      commission: new Number(form.get('commission')?.value).toFixed(2),
      email: form.get('email')?.value,
      employeeType: select,
      matriculation: form.get('matriculation')?.value,
      name: form.get('name')?.value,
      phone: form.get('phone')?.value,
    };

    return dto;
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
