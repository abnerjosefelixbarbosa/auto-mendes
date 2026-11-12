import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom, Observable } from 'rxjs';
import { Brand } from '../model/brand';

interface BrandRequest {
  name: string | null;
}

@Injectable({
  providedIn: 'root',
})
export class BrandService {
  private url = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  registerBrand(brand: Brand): Promise<Brand> {
    const request: BrandRequest = {
      name: brand.name,
    };

    return firstValueFrom(this.http.post<Brand>(`${this.url}/brands`, request));
  }
}
