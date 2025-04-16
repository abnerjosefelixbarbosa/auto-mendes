package com.auto_mendes.backend.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.auto_mendes.backend.dto.VehicleRequestDTO;
import com.auto_mendes.backend.dto.VehicleResponseDTO;
import com.auto_mendes.backend.service.VehicleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {
	private final VehicleService vehicleService;
	
	@PostMapping(value = "/register-vehicle")
	public ResponseEntity<VehicleResponseDTO> registerVehicle(@Valid @RequestBody VehicleRequestDTO dto) {
		VehicleResponseDTO response = vehicleService.registerVehicle(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping(value = "/update-vehicle-by-id")
	public ResponseEntity<VehicleResponseDTO> updateVehicleById(@RequestParam String id, @Valid @RequestBody VehicleRequestDTO dto) {
		VehicleResponseDTO response = vehicleService.updateVehicleById(id, dto);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(value = "/list-vehicle-by-model")
	public ResponseEntity<Page<VehicleResponseDTO>> listVehicleByModel(String model, Pageable pageable) {
		Page<VehicleResponseDTO> page = vehicleService.listVehicleByModel(model, pageable);
		
		return ResponseEntity.status(HttpStatus.OK).body(page);
	}
}