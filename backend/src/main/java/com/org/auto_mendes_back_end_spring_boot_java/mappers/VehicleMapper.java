package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.VehicleRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.VehicleResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Car;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Motorcycle;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces.IVehicleMapper;

@Component
public class VehicleMapper implements IVehicleMapper { 
	public Car toCar(VehicleRequestDTO dto) {
		Car car = new Car();
		
		BeanUtils.copyProperties(dto, car);
		
		return car;
	}

	public Motorcycle toMotorcycle(VehicleRequestDTO dto) {
		Motorcycle motorcycle = new Motorcycle();
		
		BeanUtils.copyProperties(dto, motorcycle);
		
		return motorcycle;
	}

	public VehicleResponseDTO toVehicleResponseDTO(Motorcycle motorcycle) {
		VehicleResponseDTO dto = new VehicleResponseDTO();
		
		BeanUtils.copyProperties(motorcycle, dto);
		
		return dto;
	}

	public VehicleResponseDTO toVehicleResponseDTO(Car car) {
        VehicleResponseDTO dto = new VehicleResponseDTO();
		
		BeanUtils.copyProperties(car, dto);
		
		return dto;
	}
}
