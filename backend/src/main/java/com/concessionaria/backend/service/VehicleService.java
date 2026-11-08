package com.concessionaria.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concessionaria.backend.entity.Vehicle;
import com.concessionaria.backend.entity.enums.TransmissionType;
import com.concessionaria.backend.entity.enums.VehicleStatus;

public interface VehicleService {
	Vehicle registerVehicle(Vehicle vehicle);

	Vehicle updateVehicleById(String id, Vehicle vehicle);

	void updateVehicleByPlate(String plate, Vehicle vehicle);

	Vehicle findVehicleById(String id);

	Page<Vehicle> listVehicles(TransmissionType transmissionType, VehicleStatus vehicleStatus, String color,
			String plate, Pageable pageable);

	Vehicle findVehicleByPlate(String plate);
}