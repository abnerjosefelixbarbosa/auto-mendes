package com.concessionaria.backend.mapper;

import com.concessionaria.backend.dto.request.VehicleRequestDTO;
import com.concessionaria.backend.dto.response.ModelResponseDTO;
import com.concessionaria.backend.dto.response.VehicleResponseDTO;
import com.concessionaria.backend.entity.Model;
import com.concessionaria.backend.entity.Vehicle;

public class VehicleMapper {
	public static Vehicle toVehicle(VehicleRequestDTO request) {
		Model model = new Model(null, request.modelName(), null, null);

		Vehicle vehicle = new Vehicle(null, request.plate(), request.transmissionType(), request.vehicleStatus(),
				request.color(), request.price(), model, null);

		return vehicle;
	}

	public static VehicleResponseDTO toVehicleResponseDTO(Vehicle vehicle) {
		Model model = vehicle.getModel();

		ModelResponseDTO modelResponseDTO = new ModelResponseDTO(model.getId(), model.getName(), null);

		VehicleResponseDTO response = new VehicleResponseDTO(vehicle.getId(), vehicle.getPlate(),
				vehicle.getTransmissionType(), vehicle.getVehicleStatus(), vehicle.getColor(), vehicle.getPrice(),
				modelResponseDTO);

		return response;
	}
}