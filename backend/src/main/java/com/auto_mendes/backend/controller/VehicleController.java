package com.auto_mendes.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto_mendes.backend.model.dto.request.VehicleRequestDTO;
import com.auto_mendes.backend.model.dto.response.VehicleResponseDTO;
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
}