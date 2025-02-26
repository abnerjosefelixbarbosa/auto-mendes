package com.org.auto_mendes_back_end_spring_boot_java.services.interfaces;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.VehicleRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.VehicleResponseDTO;

public interface IVehicleService {
	VehicleResponseDTO registerVehicle(VehicleRequestDTO dto);
}