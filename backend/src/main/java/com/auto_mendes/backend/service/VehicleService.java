package com.auto_mendes.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.auto_mendes.backend.dto.VehicleRequestDTO;
import com.auto_mendes.backend.dto.VehicleResponseDTO;

public interface VehicleService {
	VehicleResponseDTO registerVehicle(VehicleRequestDTO dto);

	VehicleResponseDTO updateVehicleById(String id, VehicleRequestDTO dto);

	Page<VehicleResponseDTO> listVehicleByModel(String model, Pageable pageable);
}
