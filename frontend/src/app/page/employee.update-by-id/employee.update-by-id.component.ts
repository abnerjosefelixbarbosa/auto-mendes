import { Component, inject, OnInit } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { EmployeeRequestDTO, EmployeeResponseDTO } from '../../service/employee/employee.service';
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from './../../service/employee/employee.service';
import { messages } from '../../utils/message';
import { DatePipe } from '@angular/common';

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
    const id = this.router.snapshot.paramMap.get('id');

    this.employeeService
      .getEmployeeById(id!)
      .then((value) => {
        this.replace(value);
      })
      .catch((e) => (this.message.error = e.error.message));
  }

  confirm() {
    try {
      const id = this.router.snapshot.paramMap.get('id');

      const dto: EmployeeRequestDTO = {
        ...this.form.value
      }

      /*
      this.employeeService.updateEmployeeById(id!, dto).then((value) => {
        console.log(value);
      }).catch((e) => console.log(e.error.message));
      */
      this.employeeService.updateEmployeeById(id!, dto);
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
