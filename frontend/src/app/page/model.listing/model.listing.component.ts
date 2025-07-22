import { Component, inject, OnInit } from '@angular/core';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { messages } from '../../utils/message';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ModelMapper } from '../../mapper/model.mapper';
import {
  ModelResponseDTO,
  ModelService,
} from '../../service/model/model.service';

@Component({
  selector: 'app-model.listing',
  imports: [NavbarComponent, ReactiveFormsModule],
  templateUrl: './model.listing.component.html',
  styleUrl: './model.listing.component.css',
})
export class ModelListingComponent implements OnInit {
  items = new Array<ModelResponseDTO>();
  message = messages;
  form: FormGroup;
  private modelMapper = inject(ModelMapper);
  private modelService = inject(ModelService);

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      id: [''],
      name: ['', [Validators.required, Validators.maxLength(50)]],
      brandName: ['', [Validators.required, Validators.maxLength(50)]],
    });
  }

  ngOnInit() {
    this.cleanMessage();

    this.listModels();
  }

  update(item: ModelResponseDTO) {
    this.cleanMessage();

    this.replace(item);
  }

  confirm() {
    this.cleanMessage();

    const id: string = this.form.get('id')?.value;

    const dto = this.modelMapper.toBrandDTO(this.form);

    try {
      this.modelService
        .updateModelById(id!, dto)
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

  private listModels() {
    this.modelService.listModels().then((value) => {
      this.items = value;
    });
  }

  private cleanMessage() {
    this.message.sucess = '';

    this.message.error = '';
  }

  private replace(item: ModelResponseDTO) {
    this.form.get('id')?.setValue(item.id);
    this.form.get('name')?.setValue(item.name);
    this.form.get('brandName')?.setValue(item.brandName);
  }
}
