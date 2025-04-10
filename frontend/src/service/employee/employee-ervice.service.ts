import { Injectable } from '@angular/core';
import { BrandResponseDTO } from '../../model/dto/response/BrandResponseDTO';
import { BrandRequestDTO } from '../../model/dto/request/BrandRequestDTO';

export interface IEmployee {
  register(dto: BrandRequestDTO): BrandResponseDTO;
}

@Injectable({
  providedIn: 'root'
})
export class EmployeeService implements IEmployee {

  constructor() { }


  register(dto: BrandRequestDTO): BrandResponseDTO {
    throw new Error('Method not implemented.');
  }
}
