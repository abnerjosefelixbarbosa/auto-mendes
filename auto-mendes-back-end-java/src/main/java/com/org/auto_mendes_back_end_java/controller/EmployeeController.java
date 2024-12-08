package com.org.auto_mendes_back_end_java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.auto_mendes_back_end_java.dto.EmployeeRequest;
import com.org.auto_mendes_back_end_java.dto.EmployeeResponse;
import com.org.auto_mendes_back_end_java.service.IEmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;

	@PostMapping(value = "/register-employee")
	public ResponseEntity<EmployeeResponse> registerEmployee(@RequestBody @Valid EmployeeRequest request) {
		EmployeeResponse response = employeeService.registerEmployee(request);

		return ResponseEntity.status(201).body(response);
	}

	@PatchMapping(value = "/update-employee")
	public ResponseEntity<EmployeeResponse> updateEmployee(@RequestParam String cpf, @RequestBody @Valid EmployeeRequest request) {
		EmployeeResponse response = employeeService.updateEmployee(cpf, request);

		return ResponseEntity.status(200).body(response);
	}
}