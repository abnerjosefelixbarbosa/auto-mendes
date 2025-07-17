import { Component, inject, OnInit } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import {
  BrandResponseDTO,
  BrandService,
} from '../../service/brand/brand.service';
import { messages } from '../../utils/message';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-brand.listing',
  imports: [NavbarComponent, ReactiveFormsModule],
  templateUrl: './brand.listing.component.html',
  styleUrl: './brand.listing.component.css',
})
export class BrandListingComponent implements OnInit {
  items = new Array<BrandResponseDTO>();
  message = messages;
  form: FormGroup;
  private brandService = inject(BrandService);

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      id: [''],
      name: ['', [Validators.required, Validators.maxLength(50)]],
    });
  }

  ngOnInit() {
    this.cleanMessage();

    this.listBrands();
  }

  update(item: BrandResponseDTO) {
    this.cleanMessage();

    this.replace(item);
  }

  confirm() {

  }

  private replace(item: BrandResponseDTO) {
    this.form.get('name')?.setValue(item.name);
  }

  private listBrands() {
    this.brandService.listBrands().then((value) => {
      this.items = value;
    });
  }

  private cleanMessage() {
    this.message.sucess = '';

    this.message.error = '';
  }
}
