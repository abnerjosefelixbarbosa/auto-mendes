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

import com.auto_mendes.backend.dto.VehicleRequestDTO;
import com.auto_mendes.backend.dto.VehicleResponseDTO;
import com.auto_mendes.backend.service.IVehicleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/vehicles")
public class VehicleController {
	@Autowired
	private IVehicleService vehicleService;
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/register-vehicle", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehicleResponseDTO> registerVehicle(@RequestBody @Valid VehicleRequestDTO dto) {
		VehicleResponseDTO response = vehicleService.registerVehicle(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@PutMapping(value = "/update-vehicle-id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehicleResponseDTO> updateVehicleById(@RequestParam String id,
			@RequestBody @Valid VehicleRequestDTO dto) {
		VehicleResponseDTO response = vehicleService.updateVehicleById(id, dto);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/list-vehicles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<VehicleResponseDTO>> listVehicles(Pageable pageable) {
		Page<VehicleResponseDTO> page = vehicleService.listVehicles(pageable);

		return ResponseEntity.status(HttpStatus.OK).body(page);
	}
}
