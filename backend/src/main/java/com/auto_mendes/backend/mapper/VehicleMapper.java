package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.VehicleRequestDTO;
import com.auto_mendes.backend.dto.VehicleResponseDTO;
import com.auto_mendes.backend.entity.Car;
import com.auto_mendes.backend.entity.Motorcycle;
import com.auto_mendes.backend.entity.Vehicle;

public interface VehicleMapper {
	Car toCar(VehicleRequestDTO dto);
	
	Motorcycle toMotorcycle(VehicleRequestDTO dto);
	
    VehicleResponseDTO toVehicleResponseDTO(Car car);
	
    VehicleResponseDTO toVehicleResponseDTO(Motorcycle motorcycle);
    
    VehicleResponseDTO toVehicleResponseDTO(Vehicle vehicle);
}
