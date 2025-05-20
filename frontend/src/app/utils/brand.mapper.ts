import { Injectable } from "@angular/core";
import { BrandRequestDTO } from "../service/brand/brand.service";
import { FormGroup } from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class BrandMapper {

  constructor() {}

  toEmployeeRequestDTO(form: FormGroup) {
    let data: BrandRequestDTO | null = null;

    data = {
      ...form.value
    }

    return data!;
  }
}