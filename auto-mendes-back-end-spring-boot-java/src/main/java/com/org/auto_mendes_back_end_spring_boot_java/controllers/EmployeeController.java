package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDto;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDto;
import com.org.auto_mendes_back_end_spring_boot_java.services.EmployeeServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeServiceInterface employeeService;
	
	@PostMapping(value = "/register-employee")
	public ResponseEntity<EmployeeResponseDto> registerEmployee(@RequestBody @Valid EmployeeRequestDto request) {
		EmployeeResponseDto response = employeeService.registerEmployee(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping(value = "/list-employees")
	public ResponseEntity<Page<EmployeeResponseDto>> listEmployees(Pageable pageable) {
		Page<EmployeeResponseDto> responses = employeeService.listEmployees(pageable);
		
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
}