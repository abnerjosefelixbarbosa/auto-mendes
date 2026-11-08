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

import com.concessionaria.backend.dto.request.VehicleRequestDTO;
import com.concessionaria.backend.dto.response.VehicleResponseDTO;
import com.concessionaria.backend.entity.Vehicle;
import com.concessionaria.backend.entity.enums.TransmissionType;
import com.concessionaria.backend.entity.enums.VehicleStatus;
import com.concessionaria.backend.mapper.VehicleMapper;
import com.concessionaria.backend.service.VehicleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {
	private final VehicleService vehicleService;

	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	@Operation(summary = "registrar veículo.", description = "registra um veículo.")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "registra um veículo."),
			@ApiResponse(responseCode = "400", description = "retorna um erro de requesição."),
			@ApiResponse(responseCode = "404", description = "retorna um erro de conteudo não encontrado.") })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<VehicleResponseDTO> registerVehicle(@RequestBody @Valid VehicleRequestDTO request) {
		Vehicle vehicle = VehicleMapper.toVehicle(request);
		
		Vehicle registeredVehicle = vehicleService.registerVehicle(vehicle);

		VehicleResponseDTO response = VehicleMapper.toVehicleResponseDTO(registeredVehicle);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@Operation(summary = "atualizar veículo pelo id.", description = "atualiza um veículo pelo id.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "atualiza um veículo pelo id."),
			@ApiResponse(responseCode = "400", description = "retorna um erro de requesição."),
			@ApiResponse(responseCode = "404", description = "retorna um erro de conteudo não encontrado.") })
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public ResponseEntity<VehicleResponseDTO> updateVehicleById(@PathVariable String id,
			@RequestBody @Valid VehicleRequestDTO request) {
		Vehicle vehicle = VehicleMapper.toVehicle(request);
		
		Vehicle updatedVehicle = vehicleService.updateVehicleById(id, vehicle);
		
		VehicleResponseDTO response = VehicleMapper.toVehicleResponseDTO(updatedVehicle);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@Operation(summary = "procurar veículo pelo id.", description = "procura um veículo pelo id.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "procura um veículo pelo id."),
			@ApiResponse(responseCode = "400", description = "retorna um erro de requesição."),
			@ApiResponse(responseCode = "404", description = "retorna um erro de conteudo não encontrado.") })
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public ResponseEntity<VehicleResponseDTO> findVehicleById(@PathVariable String id) {
		Vehicle foundVehicle = vehicleService.findVehicleById(id);
		
		VehicleResponseDTO response = VehicleMapper.toVehicleResponseDTO(foundVehicle);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@Operation(summary = "listar varios veículos.", description = "lista varios veículos.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "lista varios veículos."),
			@ApiResponse(responseCode = "400", description = "retorna um erro de requesição."),
			@ApiResponse(responseCode = "404", description = "retorna um erro de conteudo não encontrado.") })
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public ResponseEntity<Page<VehicleResponseDTO>> listVehicles(
			@RequestParam(defaultValue = "") TransmissionType transmissionType,
			@RequestParam(defaultValue = "") VehicleStatus vehicleStatus, @RequestParam(defaultValue = "") String color,
			@RequestParam(defaultValue = "") String plate, Pageable pageable) {
		Page<Vehicle> page = vehicleService.listVehicles(transmissionType, vehicleStatus, color, plate,
				pageable);
		
		Page<VehicleResponseDTO> response = page.map(VehicleMapper::toVehicleResponseDTO);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}