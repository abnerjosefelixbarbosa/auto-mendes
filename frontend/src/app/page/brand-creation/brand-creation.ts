import { Component, inject } from '@angular/core';
import { Brand } from '../../model/brand';
import { BrandService } from '../../service/brand-service';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ToastService } from '../../service/toast-service';
import { Navbar } from '../../components/navbar/navbar';

@Component({
  selector: 'app-brand-creation',
  standalone: true,
  imports: [ReactiveFormsModule, Navbar],
  styleUrl: './brand-creation.css',
  templateUrl: './brand-creation.html',
})
export class BrandCreation {
  private brandService = inject(BrandService);
  private toastService = inject(ToastService);

  brandForm: FormGroup;
  message: string = '';
  showAlertSuccess: boolean = false;
  showAlertDanger: boolean = false;
  alertType: string = 'danger';

  constructor() {
    this.brandForm = new FormGroup({
      name: new FormControl<string>('', [Validators.required, Validators.maxLength(100)]),
    });
  }

  registerBrand() {
    const brand: Brand = { id: null, name: this.brandForm.get('name')?.value, models: null };

    this.brandService
      .registerBrand(brand)
      .then(() => {
        this.toastService.success('Marca registrada.');
      })
      .catch((error) => {
        this.toastService.error(error.error.message);
      });
  }
}
