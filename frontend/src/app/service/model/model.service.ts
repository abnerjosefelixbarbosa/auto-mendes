import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { urlBase } from '../../../utils/url';

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
  constructor(private http: HttpClient) {}

  registerModel(modelRequestDTO: ModelRequestDTO) {
    return firstValueFrom(
      this.http.post<ModelResponseDTO>(
        `${urlBase.dev}/api/models/register-model`,
        modelRequestDTO
      )
    );
  }

  updateModelById(id: string, modelRequestDTO: ModelRequestDTO) {
    return firstValueFrom(
      this.http.put<ModelResponseDTO>(
        `${urlBase.dev}/api/models/update-model-by-id?id=${id}`,
        modelRequestDTO
      )
    );
  }

  listModels() {
    return firstValueFrom(
      this.http.get<ModelResponseDTO[]>(`${urlBase.dev}/api/models/list-models`)
    );
  }
}
