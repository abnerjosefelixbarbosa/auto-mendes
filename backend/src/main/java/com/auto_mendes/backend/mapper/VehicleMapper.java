package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.request.VehicleRequestDTO;
import com.auto_mendes.backend.dto.response.VehicleResponseDTO;
import com.auto_mendes.backend.model.Car;
import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.model.Motorcycle;
import com.auto_mendes.backend.model.Vehicle;

public class VehicleMapper {
	public static Car toCar(VehicleRequestDTO data) {
		Model model = new Model(null, data.getModelName(), null, null);

		return new Car(null, data.getPlate(), data.getTransmissionType(), data.getPrice(), data.getVehicleType(), model, null);
	}

	public static Motorcycle toMotorcycle(VehicleRequestDTO data) {
		Model model = new Model(null, data.getModelName(), null, null);

		return new Motorcycle(null, data.getPlate(), data.getTransmissionType(), data.getPrice(), data.getVehicleType(), model, null);
	}

	public static VehicleResponseDTO toVehicleResponseDTO(Car data) {
		return new VehicleResponseDTO(data.getId(), data.getPlate(), data.getPrice(), data.getVehicleType(), data.getModel().getName());
	}

	public static VehicleResponseDTO toVehicleResponseDTO(Motorcycle data) {
		return new VehicleResponseDTO(data.getId(), data.getPlate(), data.getPrice(), data.getVehicleType(),
				data.getModel().getName());
	}

	public static VehicleResponseDTO toVehicleResponseDTO(Vehicle data) {
		return new VehicleResponseDTO(data.getId(), data.getPlate(), data.getPrice(), data.getVehicleType(),
				data.getModel().getName());
	}
}
