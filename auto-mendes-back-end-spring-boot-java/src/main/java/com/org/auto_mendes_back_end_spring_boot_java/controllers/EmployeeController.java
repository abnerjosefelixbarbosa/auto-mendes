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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;
import com.org.auto_mendes_back_end_spring_boot_java.services.EmployeeServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeServiceInterface employeeService;

	@PostMapping(value = "/register-employee")
	public ResponseEntity<EmployeeResponseDTO> registerEmployee(@RequestBody @Valid EmployeeRequestDTO request) {
		EmployeeResponseDTO employeeResponseDTO = employeeService.registerEmployee(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponseDTO);
	}

	@GetMapping(value = "/list-employees")
	public ResponseEntity<Page<EmployeeResponseDTO>> listEmployees(Pageable pageable) {
		Page<EmployeeResponseDTO> page = employeeService.listEmployees(pageable);

		return ResponseEntity.status(HttpStatus.OK).body(page);
	}

	@GetMapping(value = "/list-employees-by-position")
	public ResponseEntity<Page<EmployeeResponseDTO>> listEmployeesByPosition(Pageable pageable,
			@RequestParam String employeeType) {
		Page<EmployeeResponseDTO> page = employeeService.listEmployeesByPosition(pageable,
				EmployeeType.valueOf(employeeType));

		return ResponseEntity.status(HttpStatus.OK).body(page);
	}

	@GetMapping(value = "/list-employees-by-matriculation")
	public ResponseEntity<Page<EmployeeResponseDTO>> listEmployeesByMatriculation(Pageable pageable,
			@RequestParam String matriculation) {
		Page<EmployeeResponseDTO> page = employeeService.listEmployeesByMatriculation(pageable, matriculation);

		return ResponseEntity.status(HttpStatus.OK).body(page);
	}
}