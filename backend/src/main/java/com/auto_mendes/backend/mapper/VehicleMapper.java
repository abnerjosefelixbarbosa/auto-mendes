package com.auto_mendes.backend.mapper;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.dto.BrandResponseDTO;
import com.auto_mendes.backend.dto.ModelResponseDTO;
import com.auto_mendes.backend.dto.VehicleRequestDTO;
import com.auto_mendes.backend.dto.VehicleResponseDTO;
import com.auto_mendes.backend.model.Car;
import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.model.Motocycle;
import com.auto_mendes.backend.model.Vehicle;

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
		BrandResponseDTO brandResponseDTO = new BrandResponseDTO();
		brandResponseDTO.setId(car.getModel().getBrand().getId());
		brandResponseDTO.setName(car.getModel().getBrand().getName());
		
		ModelResponseDTO modelResponseDTO = new ModelResponseDTO();
		modelResponseDTO.setId(car.getId());
		modelResponseDTO.setName(car.getModel().getName());
		
		VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO();
		vehicleResponseDTO.setId(car.getId());
		vehicleResponseDTO.setModelName(car.getModel().getName());
		vehicleResponseDTO.setPlate(car.getPlate());
		vehicleResponseDTO.setPrice(car.getPrice());
		vehicleResponseDTO.setTransmissionType(car.getTransmissionType());
		vehicleResponseDTO.setVehicleType(car.getVehicleType());
		vehicleResponseDTO.setBarndName(car.getModel().getBrand().getName());
		
		return vehicleResponseDTO;
	}

	public VehicleResponseDTO toDTO(Motocycle motocycle) {
		VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO();
		vehicleResponseDTO.setId(motocycle.getId());
		vehicleResponseDTO.setModelName(motocycle.getModel().getName());
		vehicleResponseDTO.setPlate(motocycle.getPlate());
		vehicleResponseDTO.setPrice(motocycle.getPrice());
		vehicleResponseDTO.setTransmissionType(motocycle.getTransmissionType());
		vehicleResponseDTO.setVehicleType(motocycle.getVehicleType());
		vehicleResponseDTO.setBarndName(motocycle.getModel().getBrand().getName());
		
		return vehicleResponseDTO;
	}
	
	public VehicleResponseDTO toDTO(Vehicle vehicle) {
		VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO();
		vehicleResponseDTO.setId(vehicle.getId());
		vehicleResponseDTO.setModelName(vehicle.getModel().getName());
		vehicleResponseDTO.setPlate(vehicle.getPlate());
		vehicleResponseDTO.setPrice(vehicle.getPrice());
		vehicleResponseDTO.setTransmissionType(vehicle.getTransmissionType());
		vehicleResponseDTO.setVehicleType(vehicle.getVehicleType());
		vehicleResponseDTO.setBarndName(vehicle.getModel().getBrand().getName());
		
		return vehicleResponseDTO;
	}
}