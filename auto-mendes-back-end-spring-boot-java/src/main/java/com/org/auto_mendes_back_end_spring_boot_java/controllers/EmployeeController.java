package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequest;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponse;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IEmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;

	@PostMapping(value = "/register-employee")
	public ResponseEntity<EmployeeResponse> registerEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
		EmployeeResponse employeeResponse = employeeService.registerEmployee(employeeRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
	}
}