package com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.VehicleRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.VehicleResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Car;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Motorcycle;

@Mapper
public interface IVehicleMapper {
	@Mapping(target = "id", expression = "java(UlidCreator.getUlid().toString())")
	@Mapping(target = "model", expression = "java(new Model(null, dto.getModelName(), null, null))")
	@Mapping(target = "saleVehicles", ignore = true)
	Car toCar(VehicleRequestDTO dto);
	@Mapping(target = "id", expression = "java(UlidCreator.getUlid().toString())")
	@Mapping(target = "model", expression = "java(new Model(null, dto.getModelName(), null, null))")
	@Mapping(target = "saleVehicles", ignore = true)
	Motorcycle toMotorcycle(VehicleRequestDTO dto);
	@Mapping(target = "vehicleType", expression = "java(VehicleType.MOTORCYCLE)")
	@Mapping(target = "modelName", expression = "java(motorcycle.getModel().getName())")
	VehicleResponseDTO toVehicleResponseDTO(Motorcycle motorcycle);
	@Mapping(target = "vehicleType", expression = "java(VehicleType.CAR)")
	@Mapping(target = "modelName", expression = "java(car.getModel().getName())")
	VehicleResponseDTO toVehicleResponseDTO(Car car);
}