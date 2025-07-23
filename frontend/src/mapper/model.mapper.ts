import { Injectable } from "@angular/core";
import { ModelRequestDTO } from "../app/service/model/model.service";
import { FormGroup } from "@angular/forms";

@Injectable({
  providedIn: 'root',
})
export class ModelMapper {
  toBrandDTO(form: FormGroup) {
    const dto: ModelRequestDTO = {
      name: form.get('name')?.value,
      brandName: form.get('brandName')?.value,
    };

    return dto;
  }
}