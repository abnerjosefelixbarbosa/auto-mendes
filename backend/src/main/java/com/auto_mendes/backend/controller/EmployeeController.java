package com.auto_mendes.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.EmployeeResponseDTO;
import com.auto_mendes.backend.service.IEmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;

	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Cria um funcionário."),
			@ApiResponse(responseCode = "400", description = "Retorna um erro na requesição.") })
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(summary = "Registra funcionário.", description = "Registra um funcionário.")
	@PostMapping(value = "/register-employee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeResponseDTO> registerEmployee(@RequestBody @Valid EmployeeRequestDTO dto) {
		EmployeeResponseDTO response = employeeService.registerEmployee(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Atualiza um funcionário."),
			@ApiResponse(responseCode = "400", description = "Retorna um erro na requesição."),
			@ApiResponse(responseCode = "404", description = "Retorna funcionário não encontrado.") })
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Atualiza funcionário pelo id.", description = "Atualiza um funcionário pelo id.")
	@PutMapping(value = "/update-employee-id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeResponseDTO> updateEmployeeById(@RequestParam String id,
			@RequestBody @Valid EmployeeRequestDTO dto) {
		EmployeeResponseDTO response = employeeService.updateEmployeeById(id, dto);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Retorna todos os funcionários.") })
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Lista funcionários.", description = "Lista todos os funcionário.")
	@GetMapping(value = "/list-employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<EmployeeResponseDTO>> listEmployees(Pageable pageable) {
		Page<EmployeeResponseDTO> page = employeeService.listEmployees(pageable);

		return ResponseEntity.status(HttpStatus.OK).body(page);
	}
}