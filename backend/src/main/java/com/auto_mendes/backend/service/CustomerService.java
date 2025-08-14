package com.auto_mendes.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.CustomerRequestDTO;
import com.auto_mendes.backend.dto.CustomerResponseDTO;
import com.auto_mendes.backend.model.Customer;
import com.auto_mendes.backend.repository.ICustomerRepository;
import com.auto_mendes.backend.validation.ICustomerValidation;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private ICustomerRepository customerRepository;
	@Autowired
	private ICustomerValidation customerValidation;

	public CustomerResponseDTO registerCustomer(CustomerRequestDTO dto) {
		Customer customer = new Customer(dto);
		
		customerValidation.validateCustomer(customer);
		
		Customer customerSaved = customerRepository.save(customer);
		
		return new CustomerResponseDTO(customerSaved);
	}
}