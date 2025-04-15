import { Component } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-employee-registration',
  imports: [NavbarComponent],
  templateUrl: './employee-registration.component.html',
  styleUrl: './employee-registration.component.css',
})
export class EmployeeRegistrationComponent {
  fg!: FormGroup;

  constructor(private fb: FormBuilder) {
    this.fg = this.fb.group({
      name: ['', [Validators.required, Validators.maxLength(100)]],
    });
  }

  onSubmit() {
    if (this.fg.valid) {
      console.log(this.fg.value);
    } else {
      this.fg.markAllAsTouched();
    }
  }
}
