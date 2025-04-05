package com.auto_mendes.backend.service.impl;

import org.springframework.stereotype.Service;

import com.auto_mendes.backend.mapper.VehicleMapper;
import com.auto_mendes.backend.model.dto.request.VehicleRequestDTO;
import com.auto_mendes.backend.model.dto.response.VehicleResponseDTO;
import com.auto_mendes.backend.model.entity.Car;
import com.auto_mendes.backend.model.entity.Model;
import com.auto_mendes.backend.model.entity.Motorcycle;
import com.auto_mendes.backend.repository.CarRepository;
import com.auto_mendes.backend.repository.ModelRepository;
import com.auto_mendes.backend.repository.MotorcycleRepository;
import com.auto_mendes.backend.service.VehicleService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
	private final VehicleMapper vehicleMapper; 
	private final ModelRepository modelRepository;
	private final CarRepository carRepository;
	private final MotorcycleRepository motorcycleRepository;

	public VehicleResponseDTO registerVehicle(VehicleRequestDTO dto) {
		VehicleResponseDTO response = null;
		
		switch (dto.vehicleType().ordinal()) {
		case 0: {
			Car car = vehicleMapper.toCar(dto);
			
			Model modelFound = modelRepository.findByName(car.getModel().getName())
					.orElseThrow(() -> new EntityNotFoundException("Nome do modelo não encontrado."));
			
			car.setModel(modelFound);
			
			response = vehicleMapper.toVehicleResponseDTO(car);
			
			break;
		}
        case 1: {
        	Motorcycle motorcycle = vehicleMapper.toMotorcycle(dto);
        	
        	Model modelFound = modelRepository.findByName(motorcycle.getModel().getName())
					.orElseThrow(() -> new EntityNotFoundException("Nome do modelo não encontrado."));
	
        	motorcycle.setModel(modelFound);
        	
        	response = vehicleMapper.toVehicleResponseDTO(motorcycle);
			
			break;
		}
		default:
			break;
		}
		
		return response;
	}
}