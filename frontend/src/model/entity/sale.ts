import { PaymentType } from '../enums/payment_type';
import { Saler } from './saler';
import { Customer } from './customer';

export interface Sale {
  id: string;
  dateTime: Date;
  paymentType: PaymentType;
  total: number;
  saler: Saler;
  customer: Customer;
}
