package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.model.dto.request.VehicleRequestDTO;
import com.auto_mendes.backend.model.dto.response.VehicleResponseDTO;
import com.auto_mendes.backend.model.entity.Car;
import com.auto_mendes.backend.model.entity.Motorcycle;

public interface VehicleMapper {
	Car toCar(VehicleRequestDTO dto);
	
	Motorcycle toMotorcycle(VehicleRequestDTO dto);
	
    VehicleResponseDTO toVehicleResponseDTO(Car car);
	
    VehicleResponseDTO toVehicleResponseDTO(Motorcycle motorcycle);
}
