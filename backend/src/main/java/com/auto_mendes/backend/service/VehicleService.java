package com.auto_mendes.backend.service;

import com.auto_mendes.backend.model.dto.request.VehicleRequestDTO;
import com.auto_mendes.backend.model.dto.response.VehicleResponseDTO;

public interface VehicleService {
	VehicleResponseDTO registerVehicle(VehicleRequestDTO dto);
}
