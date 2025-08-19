import { FormGroup } from "@angular/forms";
import { Injectable } from "@angular/core";
import { BrandRequestDTO } from "../service/brand/brand.service";

@Injectable({
  providedIn: 'root',
})
export class BrandMapper {
  toBrandDTO(form: FormGroup) {
    const dto: BrandRequestDTO = {
      name: form.get('name')?.value
    };

    return dto;
  }
}