package com.org.auto_mendes_back_end_spring_boot_java.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.VehicleRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.VehicleResponseDTO;

public interface IVehicleService {
	VehicleResponseDTO registerVehicle(VehicleRequestDTO dto);
	Page<VehicleResponseDTO> listVehicle(Pageable pageable);
}