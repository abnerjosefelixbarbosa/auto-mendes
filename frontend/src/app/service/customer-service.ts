import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from '../model/customer';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
    
    constructor(private http: HttpClient) {}

    registerCustomer(customer: Customer) {

    }     
}
