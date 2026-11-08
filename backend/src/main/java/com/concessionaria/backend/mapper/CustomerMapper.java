package com.concessionaria.backend.mapper;

import com.concessionaria.backend.dto.request.CustomerRequestDTO;
import com.concessionaria.backend.dto.response.CustomerResponseDTO;
import com.concessionaria.backend.entity.Customer;

public class CustomerMapper {
	public static Customer toCustomer(CustomerRequestDTO request) {
		Customer customer = new Customer(null, request.name(), request.document(), request.email(), request.phone(),
				request.customerType(), null);

		return customer;
	}

	public static CustomerResponseDTO toCustomerResponseDTO(Customer customer) {
		CustomerResponseDTO response = new CustomerResponseDTO(customer.getId(), customer.getName(),
				customer.getDocument(), customer.getEmail(), customer.getPhone(), customer.getCustomerType());

		return response;
	}
}
