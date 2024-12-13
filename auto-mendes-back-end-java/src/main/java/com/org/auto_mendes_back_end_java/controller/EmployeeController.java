package com.org.auto_mendes_back_end_java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.auto_mendes_back_end_java.model.dto.EmployeeRegistrationRequest;
import com.org.auto_mendes_back_end_java.model.dto.EmployeeResponse;
import com.org.auto_mendes_back_end_java.model.dto.EmployeeUpdateRequest;
import com.org.auto_mendes_back_end_java.model.service.IEmployeeService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;

	@PostMapping(value = "/register-employee",
			consumes = { MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiResponses(value = { 
					@ApiResponse(responseCode = "201", description = "employee created"),
			        @ApiResponse(responseCode = "400", description = "employee bad request"),
			        @ApiResponse(responseCode = "404", description = "employee not found"), })
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<EmployeeResponse> registerEmployee(@RequestBody @Valid EmployeeRegistrationRequest request) {
		EmployeeResponse response = employeeService.registerEmployee(request);

		return ResponseEntity.status(201).body(response);
	}
	
	@PatchMapping(value = "/update-employee",
			consumes = { MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiResponses(value = { 
					@ApiResponse(responseCode = "200", description = "employee ok"),
			        @ApiResponse(responseCode = "400", description = "employee bad request"),
			        @ApiResponse(responseCode = "404", description = "employee not found"), })
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<EmployeeResponse> updateEmployee(@RequestParam String cpf,
			@RequestBody @Valid EmployeeUpdateRequest request) {
		EmployeeResponse response = employeeService.updateEmployee(cpf,
				request);

		return ResponseEntity.status(200).body(response);
	}
	
	@GetMapping(value = "/search-employee",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiResponses(value = { 
					@ApiResponse(responseCode = "200", description = "employee ok"),
			        @ApiResponse(responseCode = "404", description = "employee not found"), })
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<EmployeeResponse> searchEmployee(@RequestParam String cpf) {
		EmployeeResponse response = employeeService.searchEmployee(cpf);

		return ResponseEntity.status(200).body(response);
	}
	
	@GetMapping(value = "/list-employee-by-name",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "employee ok") })
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Page<EmployeeResponse>> listEmployeeByName(@RequestParam String name, Pageable pageable) {
		Page<EmployeeResponse> responses = employeeService.listEmployeeByName(name,
				pageable);

		return ResponseEntity.status(200).body(responses);
	}
}