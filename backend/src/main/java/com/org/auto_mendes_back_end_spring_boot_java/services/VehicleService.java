package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.VehicleRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.VehicleResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Car;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Motorcycle;
import com.org.auto_mendes_back_end_spring_boot_java.exceptions.ValidationException;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces.IVehicleMapper;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IVehicleService;

@Service
public class VehicleService implements IVehicleService {
	@Autowired
	private IVehicleMapper vehicleMapper;
	
	public VehicleResponseDTO registerVehicle(VehicleRequestDTO dto) {
		VehicleResponseDTO vehicleResponseDTO = null;
		
		switch (dto.getVehicleType().ordinal()) {
		case 0:
			Car car = vehicleMapper.toCar(dto);
			
			vehicleResponseDTO = vehicleMapper.toVehicleResponseDTO(car);
			break;
        case 1:
        	Motorcycle motorcycle = vehicleMapper.toMotorcycle(dto); 
			
        	vehicleResponseDTO = vehicleMapper.toVehicleResponseDTO(motorcycle);
			break;	
        default:
			throw new ValidationException("Valor inexperado: " + dto.getVehicleType().ordinal());
		}
		
		return vehicleResponseDTO;
	}	
}