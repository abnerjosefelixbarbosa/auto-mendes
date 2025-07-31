import { Injectable } from "@angular/core";
import { FormGroup } from "@angular/forms";
import { ModelRequestDTO } from "../service/model/model.service";

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