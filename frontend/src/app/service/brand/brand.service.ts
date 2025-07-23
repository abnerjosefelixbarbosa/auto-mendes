import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { urlBase } from '../../../utils/url';


export interface BrandRequestDTO {
  name: string;
}

export interface BrandResponseDTO {
  id: string;
  name: string;
}

@Injectable({
  providedIn: 'root',
})
export class BrandService {
  constructor(private http: HttpClient) {}

  registerBrand(brandRequestDTO: BrandRequestDTO) {
    return firstValueFrom(
      this.http.post<BrandResponseDTO>(
        `${urlBase.dev}/api/brands/register-brand`,
        brandRequestDTO
      )
    );
  }

  updateBrandById(id: string, brandRequestDTO: BrandRequestDTO) {
    return firstValueFrom(
      this.http.put<BrandResponseDTO>(
        `${urlBase.dev}/api/brands/update-brand-by-id?id=${id}`,
        brandRequestDTO
      )
    );
  }

  listBrands() {
    return firstValueFrom(this.http.get<BrandResponseDTO[]>(`${urlBase.dev}/api/brands/list-brands`));
  }
}
