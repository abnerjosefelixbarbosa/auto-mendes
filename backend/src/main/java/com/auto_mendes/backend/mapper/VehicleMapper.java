package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.request.VehicleRequestDTO;
import com.auto_mendes.backend.dto.response.VehicleResponseDTO;
import com.auto_mendes.backend.model.Car;
import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.model.Motorcycle;
import com.auto_mendes.backend.model.Vehicle;

public class VehicleMapper {
	public static Car toCar(VehicleRequestDTO vehicleRequestDTO) {
		Model model = new Model(null, vehicleRequestDTO.getModelName(), null, null);

		return new Car(null, vehicleRequestDTO.getPlate(), vehicleRequestDTO.getTransmissionType(),
				vehicleRequestDTO.getPrice(), vehicleRequestDTO.getVehicleType(), model, null);
	}

	public static Motorcycle toMotorcycle(VehicleRequestDTO vehicleRequestDTO) {
		Model model = new Model(null, vehicleRequestDTO.getModelName(), null, null);

		return new Motorcycle(null, vehicleRequestDTO.getPlate(), vehicleRequestDTO.getTransmissionType(),
				vehicleRequestDTO.getPrice(), vehicleRequestDTO.getVehicleType(), model, null);
	}

	public static VehicleResponseDTO toVehicleResponseDTO(Car car) {
		return new VehicleResponseDTO(car.getId(), car.getPlate(), car.getPrice(), car.getVehicleType(),
				car.getModel().getName());
	}

	public static VehicleResponseDTO toVehicleResponseDTO(Motorcycle motorcycle) {
		return new VehicleResponseDTO(motorcycle.getId(), motorcycle.getPlate(), motorcycle.getPrice(),
				motorcycle.getVehicleType(), motorcycle.getModel().getName());
	}

	public static VehicleResponseDTO toVehicleResponseDTO(Vehicle vehicle) {
		return new VehicleResponseDTO(vehicle.getId(), vehicle.getPlate(), vehicle.getPrice(), vehicle.getVehicleType(),
				vehicle.getModel().getName());
	}
}
