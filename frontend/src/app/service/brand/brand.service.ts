import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';

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
  private url = 'http://localhost:8080/api/brands';

  constructor(private http: HttpClient) {}

  registerBrand(brandRequestDTO: BrandRequestDTO) {
    return firstValueFrom(
      this.http.post<BrandResponseDTO>(
        `${this.url}/register-brand`,
        brandRequestDTO
      )
    );
  }

  updateBrandById(id: string, brandRequestDTO: BrandRequestDTO) {
    return firstValueFrom(
      this.http.put<BrandResponseDTO>(
        `${this.url}/update-brand-by-id?id=${id}`,
        brandRequestDTO
      )
    );
  }

  listBrand() {
    return firstValueFrom(this.http.get<any>(`${this.url}/list-brand`)).then(
      (value) => {
        const dtos = new Array<BrandResponseDTO>();
        const content = value.content;

        dtos.push(...content);

        return dtos;
      }
    );
  }

  listBrandByName(name: string) {
    return firstValueFrom(
      this.http.get<any>(`${this.url}/list-brand-by-name?name=${name}`)
    ).then((value) => {
      const dtos = new Array<BrandResponseDTO>();
      const content = value.content;

      dtos.push(...content);

      return dtos;
    });
  }
}
