package com.auto_mendes.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.auto_mendes.backend.dto.CustomerRequestDTO;
import com.auto_mendes.backend.dto.CustomerResponseDTO;
import com.auto_mendes.backend.service.ICustomerService;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/register-customer")
	public ResponseEntity<CustomerResponseDTO> registerCustomer(@RequestBody CustomerRequestDTO dto) {
		CustomerResponseDTO response = customerService.registerCustomer(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@PutMapping(value = "/update-customer")
	public ResponseEntity<CustomerResponseDTO> updateCustomer(@RequestParam String id, @RequestBody CustomerRequestDTO response) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/search-customer-by-document")
	public ResponseEntity<List<CustomerResponseDTO>> searchCustomerByDocument(@RequestParam String document) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}