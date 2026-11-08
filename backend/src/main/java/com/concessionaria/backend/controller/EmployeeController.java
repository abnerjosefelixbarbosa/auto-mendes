package com.concessionaria.backend.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.concessionaria.backend.dto.request.EmployeeRequestDTO;
import com.concessionaria.backend.dto.response.EmployeeResponseDTO;
import com.concessionaria.backend.entity.Employee;
import com.concessionaria.backend.entity.enums.EmployeeStatus;
import com.concessionaria.backend.entity.enums.EmployeeType;
import com.concessionaria.backend.mapper.EmployeeMapper;
import com.concessionaria.backend.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "registra um funcionário."),
			@ApiResponse(responseCode = "400", description = "retorna um erro de requesição."),
			@ApiResponse(responseCode = "404", description = "retorna um erro de conteudo não encontrado."), })
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(summary = "registrar funcionário.", description = "registra um funcionário.")
	@PostMapping
	public ResponseEntity<EmployeeResponseDTO> registerEmployee(@RequestBody @Valid EmployeeRequestDTO request) {
		Employee employee = EmployeeMapper.toEmployee(request);
		
		Employee registeredEmployee = employeeService.registerEmployee(employee);
		
		EmployeeResponseDTO response = EmployeeMapper.toEmployeeResponseDTO(registeredEmployee);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "atualiza um funcionário."),
			@ApiResponse(responseCode = "400", description = "retorna um erro de requesição."),
			@ApiResponse(responseCode = "404", description = "retorna um erro de conteudo não encontrado."), })
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "atualizar funcionário pelo id.", description = "atualiza um funcionário pelo id.")
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> updateEmployeeById(@PathVariable String id,
			@RequestBody @Valid EmployeeRequestDTO request) {
		Employee employee = EmployeeMapper.toEmployee(request);
		
		Employee updatedEmployee = employeeService.updateEmployeeById(id, employee);
		
		EmployeeResponseDTO response = EmployeeMapper.toEmployeeResponseDTO(updatedEmployee); 

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "procura um funcionário pelo id."),
			@ApiResponse(responseCode = "400", description = "retorna um erro de requesição."),
			@ApiResponse(responseCode = "404", description = "retorna um erro de conteudo não encontrado."), })
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "procurar funcionário pelo id.", description = "procura um funcionário pelo id.")
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> findEmployeeById(@PathVariable String id) {
		Employee foundEmployee = employeeService.findEmployeeById(id);
		
		EmployeeResponseDTO response = EmployeeMapper.toEmployeeResponseDTO(foundEmployee); 

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "lista varios funcionários."),
			@ApiResponse(responseCode = "400", description = "retorna um erro de requesição."),
			@ApiResponse(responseCode = "404", description = "retorna um erro de conteudo não encontrado."), })
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "listar funcionários.", description = "lista varios funcionários.")
	@GetMapping
	public ResponseEntity<Page<EmployeeResponseDTO>> listEmployees(Pageable pageable,
			@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") EmployeeStatus employeeStatus,
			@RequestParam(defaultValue = "") EmployeeType employeeType) {
		Page<Employee> page = employeeService.listEmployees(name, employeeStatus, employeeType,
				pageable);
		
		Page<EmployeeResponseDTO> response = page.map(EmployeeMapper::toEmployeeResponseDTO);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
