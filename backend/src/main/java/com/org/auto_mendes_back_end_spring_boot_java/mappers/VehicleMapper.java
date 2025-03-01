package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.VehicleRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.VehicleResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Car;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Model;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Motorcycle;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces.IVehicleMapper;

@Component
public class VehicleMapper implements IVehicleMapper { 
	public Car toCar(VehicleRequestDTO dto) {
		Model model = new Model();
		model.setName(dto.getModelName());
		
		Car car = new Car();
		car.setId(UlidCreator.getUlid().toString());
		car.setModel(model);
		
		BeanUtils.copyProperties(dto, car);
		
		return car;
	}

	public Motorcycle toMotorcycle(VehicleRequestDTO dto) {
		Model model = new Model();
		model.setName(dto.getModelName());
		
		Motorcycle motorcycle = new Motorcycle();
		motorcycle.setId(UlidCreator.getUlid().toString());
		motorcycle.setModel(model);
		
		BeanUtils.copyProperties(dto, motorcycle);
		
		return motorcycle;
	}

	public VehicleResponseDTO toVehicleResponseDTO(Motorcycle motorcycle) {
		VehicleResponseDTO dto = new VehicleResponseDTO();
		dto.setModelName(motorcycle.getModel().getName());
		
		BeanUtils.copyProperties(motorcycle, dto);
		
		return dto;
	}

	public VehicleResponseDTO toVehicleResponseDTO(Car car) {
        VehicleResponseDTO dto = new VehicleResponseDTO();
        dto.setModelName(car.getModel().getName());
		
		BeanUtils.copyProperties(car, dto);
		
		return dto;
	}
}
