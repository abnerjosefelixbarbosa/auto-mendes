package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.ExceptionResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IEmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/employees")
@Tag(name = "Funcionários", description = "Operações relacionadas aos funcionários")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;

	@Operation(summary = "Registrar funcionário", description = "Registra um funcionário")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Cria um funcionário", content = @Content(schema = @Schema(implementation = EmployeeResponseDTO.class))),
			@ApiResponse(responseCode = "400", description = "Retorna um erro de requesição", content = @Content(schema = @Schema(implementation = ExceptionResponseDTO.class))), })
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/register-employee")
	public ResponseEntity<EmployeeResponseDTO> registerEmployee(@RequestBody @Valid EmployeeRequestDTO request) {
		EmployeeResponseDTO employeeResponseDTO = employeeService.registerEmployee(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponseDTO);
	}

	@Operation(summary = "Listar funcionários", description = "Lista funcionários")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna uma pagina de funcionários", content = @Content(schema = @Schema(implementation = Page.class))), })
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/list-employees")
	public ResponseEntity<Page<EmployeeResponseDTO>> listEmployees(
			@Parameter(description = "Configura a pagina", required = false) Pageable pageable) {
		Page<EmployeeResponseDTO> page = employeeService.listEmployees(pageable);

		return ResponseEntity.status(HttpStatus.OK).body(page);
	}

	@Operation(summary = "Listar funcionários pelo cargo", description = "Lista funcionários pelo cargo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna uma pagina de funcionários", content = @Content(schema = @Schema(implementation = Page.class))) })
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/list-employees-by-position")
	public ResponseEntity<Page<EmployeeResponseDTO>> listEmployeesByPosition(
			@Parameter(description = "Configura a pagina", required = false) Pageable pageable,
			@Parameter(description = "Filtra por cargo", in = ParameterIn.QUERY, required = true, example = "Manager") @RequestParam String employeeType) {
		Page<EmployeeResponseDTO> page = employeeService.listEmployeesByPosition(pageable,
				EmployeeType.valueOf(employeeType));

		return ResponseEntity.status(HttpStatus.OK).body(page);
	}

	@Operation(summary = "Listar funcionários pela matrícula", description = "Lista funcionários pela matrícula")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna uma pagina de funcionários", content = @Content(schema = @Schema(implementation = Page.class))) })
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/list-employees-by-matriculation")
	public ResponseEntity<Page<EmployeeResponseDTO>> listEmployeesByMatriculation(
			@Parameter(description = "Configura a pagina", required = false) Pageable pageable,
			@Parameter(description = "Filtra por matricula", in = ParameterIn.QUERY, required = true, example = "1") @RequestParam String matriculation) {
		Page<EmployeeResponseDTO> page = employeeService.listEmployeesByMatriculation(pageable, matriculation);

		return ResponseEntity.status(HttpStatus.OK).body(page);
	}

	@Operation(summary = "Atualizar funcionário", description = "Atualiza um funcionário pelo id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Atualiza um funcionário", content = @Content(schema = @Schema(implementation = EmployeeResponseDTO.class))),
			@ApiResponse(responseCode = "400", description = "Retorna um erro de requesição", content = @Content(schema = @Schema(implementation = ExceptionResponseDTO.class))),
			@ApiResponse(responseCode = "404", description = "Retorna um erro de não encontrado", content = @Content(schema = @Schema(implementation = ExceptionResponseDTO.class))), })
	@ResponseStatus(value = HttpStatus.OK)
	@PutMapping(value = "/update-employee-by-id")
	public ResponseEntity<EmployeeResponseDTO> updateEmployeeById(@Parameter(description = "Filtra por id", in = ParameterIn.QUERY, required = true, example = "1") @RequestParam String id,
			@RequestBody @Valid EmployeeRequestDTO request) {
		EmployeeResponseDTO employeeResponseDTO = employeeService.updateEmployeeById(id, request);

		return ResponseEntity.status(HttpStatus.OK).body(employeeResponseDTO);
	}
}