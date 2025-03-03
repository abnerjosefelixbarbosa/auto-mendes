package com.org.auto_mendes_back_end_spring_boot_java.validations;

import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Car;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Motorcycle;
import com.org.auto_mendes_back_end_spring_boot_java.exceptions.ValidationException;
import com.org.auto_mendes_back_end_spring_boot_java.validations.interfaces.IVehicleValidation;

@Component
public class VehicleValidation implements IVehicleValidation {
	public void validateCar(Car car) {
		if (car.getVehicleValue().scale() != 2)
			throw new ValidationException("Valor do veiculo deve ser de dois digitos");

	}

	public void validateMotorcycle(Motorcycle motorcycle) {
		if (motorcycle.getVehicleValue().scale() != 2)
			throw new ValidationException("Valor do veiculo deve ser de dois digitos");
	}
}