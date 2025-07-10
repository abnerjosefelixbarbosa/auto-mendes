import { Component, inject, OnInit } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import {
  EmployeeRequestDTO,
  EmployeeResponseDTO,
} from '../../service/employee/employee.service';
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from './../../service/employee/employee.service';
import { messages } from '../../utils/message';
import { DatePipe } from '@angular/common';
import { EmployeeType } from '../../enum/employee_type';

@Component({
  selector: 'app-employee.update-by-id',
  imports: [NavbarComponent, NgxMaskDirective, ReactiveFormsModule],
  templateUrl: './employee.update-by-id.component.html',
  styleUrl: './employee.update-by-id.component.css',
  providers: [DatePipe, provideNgxMask()],
})
export class EmployeeUpdateByIdComponent implements OnInit {
  form: FormGroup;
  private employeeService = inject(EmployeeService);
  message = messages;

  constructor(
    private formBuilder: FormBuilder,
    private router: ActivatedRoute,
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
  }

  ngOnInit(): void {
    this.cleanMessage();

    const id = this.router.snapshot.paramMap.get('id');

    this.employeeService
      .getEmployeeById(id!)
      .then((value) => this.replace(value))
      .catch((e) => (this.message.error = e.error.message));
  }

  confirm() {
    try {
      this.cleanMessage();

      const id = this.router.snapshot.paramMap.get('id');

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
    const date = new Date(item.birthDate);

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
