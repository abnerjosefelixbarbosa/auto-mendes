package com.auto_mendes.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.auto_mendes.backend.dto.request.VehicleRequestDTO;
import com.auto_mendes.backend.dto.response.VehicleResponseDTO;

public interface VehicleService {
	VehicleResponseDTO registerVehicle(VehicleRequestDTO vehicleRequestDTO);

	VehicleResponseDTO updateVehicleById(String id, VehicleRequestDTO vehicleRequestDTO);

	Page<VehicleResponseDTO> listVehicleByModel(String model, Pageable pageable);

	Page<VehicleResponseDTO> listVehicle(Pageable pageable);
}
