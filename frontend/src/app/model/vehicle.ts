import { TransmissionType } from '../enum/transmission.type';
import { Model } from './model';

export interface Vehicle {
  id: string;
  plate: string;
  transmissionType: TransmissionType;
  price: number;
  model: Model;
}