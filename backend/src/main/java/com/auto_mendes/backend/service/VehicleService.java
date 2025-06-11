package com.auto_mendes.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.VehicleRequestDTO;
import com.auto_mendes.backend.dto.VehicleResponseDTO;
import com.auto_mendes.backend.mapper.IVehicleMapper;
import com.auto_mendes.backend.model.Car;
import com.auto_mendes.backend.model.Motocycle;
import com.auto_mendes.backend.repository.ICarRepository;
import com.auto_mendes.backend.repository.IMotocycleRepository;
import com.auto_mendes.backend.repository.IVehicleRepository;
import com.auto_mendes.backend.validation.IVehicleValidation;

@Service
public class VehicleService implements IVehicleService {
	@Autowired
	private IVehicleRepository vehicleRepository;
	@Autowired
	private ICarRepository carRepository;
	@Autowired
	private IMotocycleRepository motocycleRepository;
	@Autowired
	private IVehicleValidation vehicleValidation;
	@Autowired
	private IVehicleMapper vehicleMapper;

	public VehicleResponseDTO registerVehicle(VehicleRequestDTO dto) {
		VehicleResponseDTO vehicleResponseDTO = null;

		switch (dto.getVehicleType().toString()) {
		case "CAR":
			vehicleResponseDTO = registerCar(dto);
			break;
		case "MOTOCYCLE":
			vehicleResponseDTO = registerMotocycle(dto);
			break;
		}

		return vehicleResponseDTO;
	}

	private VehicleResponseDTO registerCar(VehicleRequestDTO dto) {
		Car car = vehicleMapper.toCar(dto);

		vehicleValidation.validateCar(car);

		Car carSaved = carRepository.save(car);

		return vehicleMapper.toDTO(carSaved);
	}

	private VehicleResponseDTO registerMotocycle(VehicleRequestDTO dto) {
		Motocycle motocycle = vehicleMapper.toMotocycle(dto);

		vehicleValidation.validateMotocycle(motocycle);

		Motocycle motocycleSaved = motocycleRepository.save(motocycle);

		return vehicleMapper.toDTO(motocycleSaved);
	}

	public VehicleResponseDTO updateVehicleById(String id, VehicleRequestDTO dto) {
		VehicleResponseDTO vehicleResponseDTO = null;

		switch (dto.getVehicleType().toString()) {
		case "CAR":
			vehicleResponseDTO = updateCarById(id, dto);
			break;
		case "MOTOCYCLE":
			vehicleResponseDTO = updateMotocycleById(id, dto);
			break;
		}

		return vehicleResponseDTO;
	}
	
	private VehicleResponseDTO updateCarById(String id, VehicleRequestDTO dto) {
		return null;
	}
	
	private VehicleResponseDTO updateMotocycleById(String id, VehicleRequestDTO dto) {
		return null;
	}

	public Page<VehicleResponseDTO> listVehicles(Pageable pageable) {
		return null;
	}
}