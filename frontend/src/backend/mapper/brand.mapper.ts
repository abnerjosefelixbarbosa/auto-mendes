import { FormGroup } from "@angular/forms";
import { BrandRequestDTO } from "../../app/service/brand/brand.service";
import { Injectable } from "@angular/core";

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