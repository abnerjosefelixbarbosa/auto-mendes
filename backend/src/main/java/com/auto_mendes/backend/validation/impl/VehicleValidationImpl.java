package com.auto_mendes.backend.validation.impl;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.entity.Car;
import com.auto_mendes.backend.entity.Motorcycle;
import com.auto_mendes.backend.validation.VehicleValidation;

@Component
public class VehicleValidationImpl implements VehicleValidation {
	public void validateVehicle(Car car) {
		if (car.getPrice().scale() != 2) 
			throw new RuntimeException("Preço dever ter 2 digitos depois da vírgula");
	}

	public void validateVehicle(Motorcycle motorcycle) {
		if (motorcycle.getPrice().scale() != 2) 
			throw new RuntimeException("Preço dever ter 2 digitos depois da vírgula");
	}
}