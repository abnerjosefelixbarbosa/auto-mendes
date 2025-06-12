package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.VehicleRequestDTO;
import com.auto_mendes.backend.dto.VehicleResponseDTO;
import com.auto_mendes.backend.model.Car;
import com.auto_mendes.backend.model.Motocycle;
import com.auto_mendes.backend.model.Vehicle;

public interface IVehicleMapper {
	Car toCar(VehicleRequestDTO dto);
	
	Motocycle toMotocycle(VehicleRequestDTO dto);
	
	VehicleResponseDTO toDTO(Car car);
	
	VehicleResponseDTO toDTO(Motocycle motocycle);
	
	VehicleResponseDTO toDTO(Vehicle vehicle);
}