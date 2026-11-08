package com.concessionaria.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concessionaria.backend.entity.Customer;
import com.concessionaria.backend.entity.enums.CustomerType;

public interface CustomerService {
	Customer registerCustomer(Customer customer);

	Customer updateCustomerById(String id, Customer customer);

	Customer findCustomerById(String id);

	Page<Customer> listCustomers(String name, CustomerType customerType, Pageable pageable);

	Customer findCustomerByDocument(String document);
}