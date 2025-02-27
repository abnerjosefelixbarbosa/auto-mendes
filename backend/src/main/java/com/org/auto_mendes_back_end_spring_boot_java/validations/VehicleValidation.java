package com.org.auto_mendes_back_end_spring_boot_java.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Car;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Motorcycle;
import com.org.auto_mendes_back_end_spring_boot_java.exceptions.ValidationException;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IModelRepository;
import com.org.auto_mendes_back_end_spring_boot_java.validations.interfaces.IVehicleValidation;

@Component
public class VehicleValidation implements IVehicleValidation {
	@Autowired
	private IModelRepository modelRepository;

	public void validateCar(Car car) {
		boolean isExistsModelName = modelRepository.existsByName(car.getModel().getName());

		if (!isExistsModelName)
			throw new ValidationException("Modelo ");

	}

	public void validateMotorcycle(Motorcycle motorcycle) {
		boolean isExistsModelName = modelRepository.existsByName(motorcycle.getModel().getName());

		if (isExistsModelName)
			throw new ValidationException();
	}
}