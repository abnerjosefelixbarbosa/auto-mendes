import { Component, inject } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { NgxMaskDirective } from 'ngx-mask';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { SharedService } from '../../service/shared/shared.service';
import { EmployeeResponseDTO } from '../../service/employee/employee.service';

@Component({
  selector: 'app-employee.update-by-id',
  imports: [NavbarComponent, NgxMaskDirective, ReactiveFormsModule],
  templateUrl: './employee.update-by-id.component.html',
  styleUrl: './employee.update-by-id.component.css',
})
export class EmployeeUpdateByIdComponent {
  form: FormGroup;
  private sharedService = inject(SharedService);

  constructor(private formBuilder: FormBuilder) {
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

  confirm() {
    const dto: EmployeeResponseDTO = { ...this.sharedService.getData() };
    console.log(dto)
  }
}