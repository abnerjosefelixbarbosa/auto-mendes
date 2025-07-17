import { Component, inject, OnInit } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import {
  BrandResponseDTO,
  BrandService,
} from '../../service/brand/brand.service';
import { messages } from '../../utils/message';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { BrandMapper } from '../../mapper/brand.mapper';

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
  private brandMapper = inject(BrandMapper);

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
    this.cleanMessage();

    const id: string = this.form.get('id')?.value;

    const dto = this.brandMapper.toBrandDTO(this.form);

    try {
      this.brandService
        .updateBrandById(id!, dto)
        .then(() => {
          this.message.sucess = 'Marca atualizada.';

          setTimeout(() => {
            location.reload();
          }, 2000);
        })
        .catch((e) => (this.message.error = e.error.message));
    } catch (e: any) {
      this.message.error = e.message;
    }
  }

  private replace(item: BrandResponseDTO) {
    this.form.get('id')?.setValue(item.id);
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
