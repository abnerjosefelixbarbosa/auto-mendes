package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.VehicleRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.VehicleResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IVehicleService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/vehicles")
@Tag(name = "Veículos", description = "Operações relacionadas aos veículos")
public class VehicleController {
	@Autowired
	private IVehicleService vehicleService;

	@PostMapping(value = "/register-vehicle-car")
	public ResponseEntity<VehicleResponseDTO> registerVehicleCar(@RequestBody @Valid VehicleRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.registerVehicleCar(dto));
	}
	
	@PostMapping(value = "/register-vehicle-motorcycle")
	public ResponseEntity<VehicleResponseDTO> registerVehicleMotorcycle(@RequestBody @Valid VehicleRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.registerVehicleMotorcycle(dto));
	}

	@GetMapping(value = "/list-vehicles")
	public ResponseEntity<Page<VehicleResponseDTO>> listVehicles(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(vehicleService.listVehicle(pageable));
	}
}