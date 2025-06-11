package com.auto_mendes.backend.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auto_mendes.backend.model.Car;
import com.auto_mendes.backend.model.Motocycle;
import com.auto_mendes.backend.repository.ICarRepository;
import com.auto_mendes.backend.repository.IMotocycleRepository;

@Component
public class VehicleValidation implements IVehicleValidation {
	@Autowired
	private ICarRepository carRepository;
	@Autowired
	private IMotocycleRepository motocycleRepository;
	
	public void validateCar(Car car) {
		boolean isExistsPlate = carRepository.existsByPlate(car.getPlate());
		
		if (car.getPlate() != null) {
			if (car.getPlate().length() > 15) {
				throw new RuntimeException("Placa deve ter no máximo 15 caracteres.");
			}
			
			if (isExistsPlate) {
				throw new RuntimeException("Placa deve não deve ser duplicada.");
			}
		}
		
		if (car.getPrice().scale() != 2) {
			throw new RuntimeException("Preço deve ter 2 dígitos depois da vírgula.");
		}
	}
	
	public void validateMotocycle(Motocycle motocycle) {
		boolean isExistsPlate = motocycleRepository.existsByPlate(motocycle.getPlate());
		
		if (motocycle.getPlate() != null) {
			if (motocycle.getPlate().length() > 15) {
				throw new RuntimeException("Placa deve ter no máximo 15 caracteres.");
			}
			
			if (isExistsPlate) {
				throw new RuntimeException("Placa deve não deve ser duplicada.");
			}
		}
		
		if (motocycle.getPrice().scale() != 2) {
			throw new RuntimeException("Preço deve ter 2 dígitos depois da vírgula.");
		}
	}
}