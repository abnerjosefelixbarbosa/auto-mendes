package com.auto_mendes.backend.mapper;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.dto.ModelResponseDTO;
import com.auto_mendes.backend.dto.VehicleRequestDTO;
import com.auto_mendes.backend.dto.VehicleResponseDTO;
import com.auto_mendes.backend.model.Car;
import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.model.Motocycle;

@Component
public class VehicleMapper implements IVehicleMapper {
	public Car toCar(VehicleRequestDTO dto) {
		Model model = new Model();
		model.setName(dto.getModelName());
		
		Car car = new Car();
		car.setModel(model);
		car.setPlate(dto.getPlate());
		car.setPrice(dto.getPrice());
		car.setTransmissionType(dto.getTransmissionType());
		car.setVehicleType(dto.getVehicleType());
		
		return car;
	}

	public Motocycle toMotocycle(VehicleRequestDTO dto) {
		Model model = new Model();
		model.setName(dto.getModelName());
		
		Motocycle motocycle = new Motocycle();
		motocycle.setModel(model);
		motocycle.setPlate(dto.getPlate());
		motocycle.setPrice(dto.getPrice());
		motocycle.setTransmissionType(dto.getTransmissionType());
		motocycle.setVehicleType(dto.getVehicleType());
		
		return motocycle;
	}

	public VehicleResponseDTO toDTO(Car car) {
		ModelResponseDTO modelResponseDTO = new ModelResponseDTO();
		modelResponseDTO.setId(car.getId());
		modelResponseDTO.setName(car.getModel().getName());
		
		VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO();
		vehicleResponseDTO.setId(car.getId());
		vehicleResponseDTO.setDto(modelResponseDTO);
		vehicleResponseDTO.setPlate(car.getPlate());
		vehicleResponseDTO.setPrice(car.getPrice());
		vehicleResponseDTO.setTransmissionType(car.getTransmissionType());
		vehicleResponseDTO.setVehicleType(car.getVehicleType());
		
		return vehicleResponseDTO;
	}

	public VehicleResponseDTO toDTO(Motocycle motocycle) {
		ModelResponseDTO modelResponseDTO = new ModelResponseDTO();
		modelResponseDTO.setId(motocycle.getId());
		modelResponseDTO.setName(motocycle.getModel().getName());
		
		VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO();
		vehicleResponseDTO.setId(motocycle.getId());
		vehicleResponseDTO.setDto(modelResponseDTO);
		vehicleResponseDTO.setPlate(motocycle.getPlate());
		vehicleResponseDTO.setPrice(motocycle.getPrice());
		vehicleResponseDTO.setTransmissionType(motocycle.getTransmissionType());
		vehicleResponseDTO.setVehicleType(motocycle.getVehicleType());
		
		return vehicleResponseDTO;
	}
}