package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.request.VehicleRequestDTO;
import com.auto_mendes.backend.dto.response.VehicleResponseDTO;
import com.auto_mendes.backend.model.Car;
import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.model.Motorcycle;
import com.auto_mendes.backend.model.Vehicle;

public class VehicleMapper {
	public static Car toCar(VehicleRequestDTO dto) {
		Model model = new Model(null, dto.modelName(), null, null);

		return new Car(null, dto.plate(), dto.transmissionType(), dto.price(), model, null);
	}

	public static Motorcycle toMotorcycle(VehicleRequestDTO dto) {
		Model model = new Model(null, dto.modelName(), null, null);

		return new Motorcycle(null, dto.plate(), dto.transmissionType(), dto.price(), model, null);
	}

	public static VehicleResponseDTO toVehicleResponseDTO(Car car) {
		return new VehicleResponseDTO(car.getId(), car.getPlate(), car.getPrice(), car.getModel().getName());
	}

	public static VehicleResponseDTO toVehicleResponseDTO(Motorcycle motorcycle) {
		return new VehicleResponseDTO(motorcycle.getId(), motorcycle.getPlate(), motorcycle.getPrice(),
				motorcycle.getModel().getName());
	}

	public static VehicleResponseDTO toVehicleResponseDTO(Vehicle vehicle) {
		return new VehicleResponseDTO(vehicle.getId(), vehicle.getPlate(), vehicle.getPrice(),
				vehicle.getModel().getName());
	}
}
