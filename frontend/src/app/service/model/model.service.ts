import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';

export interface ModelRequestDTO {
  name: string;
  brandName: string;
}

export interface ModelResponseDTO {
  id: string;
  name: string;
  brandName: string;
}

@Injectable({
  providedIn: 'root',
})
export class ModelService {
  private url = 'http://localhost:8080/api/brands';

  constructor(private http: HttpClient) {}

  registerModel(modelRequestDTO: ModelRequestDTO) {
    return firstValueFrom(
      this.http.post<ModelResponseDTO>(
        `${this.url}/register-model`,
        modelRequestDTO
      )
    );
  }

  updateModelById(id: string, modelRequestDTO: ModelRequestDTO) {
    return firstValueFrom(
      this.http.put<ModelResponseDTO>(
        `${this.url}/update-model-by-id?id=${id}`,
        modelRequestDTO
      )
    );
  }

  listModel() {
    return firstValueFrom(this.http.get<any>(`${this.url}/list-model`)).then(
      (value) => {
        const dtos = new Array<ModelResponseDTO>();
        const content = value.content;

        dtos.push(...content);

        return dtos;
      }
    );
  }

  listModelByName(name: string) {
    return firstValueFrom(
      this.http.get<any>(`${this.url}/list-model-by-name?name=${name}`)
    ).then((value) => {
      const dtos = new Array<ModelResponseDTO>();
      const content = value.content;

      dtos.push(...content);

      return dtos;
    });
  }
}
