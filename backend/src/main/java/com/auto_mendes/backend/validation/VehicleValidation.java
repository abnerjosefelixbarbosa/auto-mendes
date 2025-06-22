package com.auto_mendes.backend.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auto_mendes.backend.model.Vehicle;
import com.auto_mendes.backend.repository.IVehicleRepository;

@Component
public class VehicleValidation implements IVehicleValidation {
	@Autowired
	private IVehicleRepository vehicleRepository;
	
	public void validateVehicle(Vehicle vehicle) {
		boolean isExistsPlate = vehicleRepository.existsByPlate(vehicle.getPlate());
		
		if (vehicle.getPlate() != null) {
			if (vehicle.getPlate().length() > 15) {
				throw new RuntimeException("Placa deve ter no máximo 15 caracteres.");
			}
			
			if (isExistsPlate) {
				throw new RuntimeException("Placa deve não deve ser duplicada.");
			}	
		}
		
		if (vehicle.getPrice().scale() != 2) {
			throw new RuntimeException("Preço deve ter 2 dígitos depois da vírgula.");
		}
	}
}