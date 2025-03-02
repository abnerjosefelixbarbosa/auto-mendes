package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.VehicleRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.VehicleResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Car;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Model;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Motorcycle;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces.IVehicleMapper;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.ICarRepository;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IMotorcycleRepository;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IVehicleRepository;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IModelService;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IVehicleService;
import com.org.auto_mendes_back_end_spring_boot_java.validations.interfaces.IVehicleValidation;

import jakarta.transaction.Transactional;

@Service
public class VehicleService implements IVehicleService {
	@Autowired
	private IVehicleMapper vehicleMapper;
	@Autowired
	private IVehicleValidation vehicleValidation;
	@Autowired
	private IModelService modelService;
	@Autowired
	private IVehicleRepository vehicleRepository;
	@Autowired
	private ICarRepository carRepository;
	@Autowired
	private IMotorcycleRepository motorcycleRepository;
	
	@Transactional
	public VehicleResponseDTO registerVehicleCar(VehicleRequestDTO dto) {
		Car car = vehicleMapper.toCar(dto);
		
		vehicleValidation.validateCar(car);
		
		Model model = modelService.findByName(car.getModel().getName());
		
		car.setModel(model);
		
		vehicleRepository.save(car);
		
		car = carRepository.save(car);
		
		return vehicleMapper.toVehicleResponseDTO(car);
	}
	
	@Transactional
	public VehicleResponseDTO registerVehicleMotorcycle(VehicleRequestDTO dto) {
		Motorcycle motorcycle = vehicleMapper.toMotorcycle(dto);
    	
    	vehicleValidation.validateMotorcycle(motorcycle);
    	
        Model model = modelService.findByName(motorcycle.getModel().getName());
		
        motorcycle.setModel(model);
        
        vehicleRepository.save(motorcycle);
        
        motorcycle = motorcycleRepository.save(motorcycle);
		
		return vehicleMapper.toVehicleResponseDTO(motorcycle);
	}

	public Page<VehicleResponseDTO> listVehicle(Pageable pageable) {
		return vehicleRepository.listVehicle(pageable).map(vehicleMapper::toVehicleResponseDTO);
	}	
}