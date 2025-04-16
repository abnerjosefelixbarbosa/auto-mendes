package com.auto_mendes.backend.mapper.impl;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.dto.VehicleRequestDTO;
import com.auto_mendes.backend.dto.VehicleResponseDTO;
import com.auto_mendes.backend.entity.Car;
import com.auto_mendes.backend.entity.Model;
import com.auto_mendes.backend.entity.Motorcycle;
import com.auto_mendes.backend.entity.Vehicle;
import com.auto_mendes.backend.mapper.VehicleMapper;

@Component
public class VehicleMapperImpl implements VehicleMapper {
	public Car toCar(VehicleRequestDTO dto) {
		Model model = new Model(null, dto.modelName(), null, null);

		return new Car(null, dto.plate(), dto.transmissionType(), dto.price(), model, null);
	}

	public Motorcycle toMotorcycle(VehicleRequestDTO dto) {
		Model model = new Model(null, dto.modelName(), null, null);

		return new Motorcycle(null, dto.plate(), dto.transmissionType(), dto.price(), model, null);
	}

	public VehicleResponseDTO toVehicleResponseDTO(Car car) {
		return new VehicleResponseDTO(car.getId(), car.getPlate(), car.getTransmissionType(), car.getPrice(),
				car.getModel().getName());
	}

	public VehicleResponseDTO toVehicleResponseDTO(Motorcycle motorcycle) {
		return new VehicleResponseDTO(motorcycle.getId(), motorcycle.getPlate(), motorcycle.getTransmissionType(), motorcycle.getPrice(),
				motorcycle.getModel().getName());
	}
	
	public VehicleResponseDTO toVehicleResponseDTO(Vehicle vehicle) {
		return new VehicleResponseDTO(vehicle.getId(), vehicle.getPlate(), vehicle.getTransmissionType(), vehicle.getPrice(),
				vehicle.getModel().getName());
	}
}
