package com.auto_mendes.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/employees")
public class EmployeeController {
	private final EmployeeService employeeService;
	
	@PostMapping(value = "/register-employee")
	public ResponseEntity<EmployeeResponseDTO> registerEmployee(@Valid @RequestBody EmployeeRequestDTO request) {
		EmployeeResponseDTO response = employeeService.registerEmployee(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}