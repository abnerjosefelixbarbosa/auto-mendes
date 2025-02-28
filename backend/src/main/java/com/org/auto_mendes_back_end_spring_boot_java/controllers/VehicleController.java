package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.VehicleRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.ExceptionResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.VehicleResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IVehicleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/vehicles")
@Tag(name = "Veículos", description = "Operações relacionadas aos veículos")
public class VehicleController {
	@Autowired
	private IVehicleService vehicleService;
	
	@Operation(summary = "Registrar veiculo", description = "Registra um veiculo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Cria um veiculo", content = @Content(schema = @Schema(implementation = EmployeeResponseDTO.class))),
			@ApiResponse(responseCode = "400", description = "Retorna um erro de requesição", content = @Content(schema = @Schema(implementation = ExceptionResponseDTO.class))), })
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/register-vehicle")
	public ResponseEntity<VehicleResponseDTO> registerVehicle(@RequestBody @Valid VehicleRequestDTO dto) {
		VehicleResponseDTO vehicleResponseDTO = vehicleService.registerVehicle(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(vehicleResponseDTO);
	}
}