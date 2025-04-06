package com.auto_mendes.backend.validation;

import com.auto_mendes.backend.model.entity.Car;
import com.auto_mendes.backend.model.entity.Motorcycle;

public interface VehicleValidation {
	void validateVehicle(Car car);
	
	void validateVehicle(Motorcycle motorcycle);
}