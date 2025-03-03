package com.org.auto_mendes_back_end_spring_boot_java.validations.interfaces;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Car;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Motorcycle;

public interface IVehicleValidation {
	void validateCar(Car car);
	void validateMotorcycle(Motorcycle motorcycle);
}