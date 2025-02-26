package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.VehicleRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.VehicleResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IVehicleService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/vehicles")
@Tag(name = "Veículos", description = "Operações relacionadas aos veículos")
public class VehicleController {
	@Autowired
	private IVehicleService vehicleService;
	
	@PostMapping(value = "/register-vehicle")
	public ResponseEntity<VehicleResponseDTO> registerVehicle(VehicleRequestDTO dto) {
		VehicleResponseDTO vehicleResponseDTO = vehicleService.registerVehicle(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(vehicleResponseDTO);
	}
}