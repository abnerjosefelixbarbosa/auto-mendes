package com.auto_mendes.backend.validation;

import com.auto_mendes.backend.model.Car;
import com.auto_mendes.backend.model.Motorcycle;

public interface VehicleValidation {
	void validateVehicle(Car car);
	
	void validateVehicle(Motorcycle motorcycle);
}