package com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.VehicleRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.VehicleResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Car;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Motorcycle;

public interface IVehicleMapper {
	Car toCar(VehicleRequestDTO dto);

	Motorcycle toMotorcycle(VehicleRequestDTO dto);

	VehicleResponseDTO toVehicleResponseDTO(Motorcycle motorcycle);

	VehicleResponseDTO toVehicleResponseDTO(Car car);
}