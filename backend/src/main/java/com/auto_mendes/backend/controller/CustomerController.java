package com.auto_mendes.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto_mendes.backend.dto.CustomerRequestDTO;
import com.auto_mendes.backend.dto.CustomerResponseDTO;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {
	
	public ResponseEntity<CustomerResponseDTO> registerCustomer(CustomerRequestDTO response) {
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	public ResponseEntity<CustomerResponseDTO> updateCustomer(String id, CustomerRequestDTO response) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	public ResponseEntity<List<CustomerResponseDTO>> searchCustomerByDocument(String document) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}