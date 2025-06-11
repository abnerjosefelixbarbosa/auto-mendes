package com.auto_mendes.backend.validation;

import com.auto_mendes.backend.model.Car;
import com.auto_mendes.backend.model.Motocycle;

public interface IVehicleValidation {
	void validateCar(Car car);
	
	void validateMotocycle(Motocycle motocycle);
}