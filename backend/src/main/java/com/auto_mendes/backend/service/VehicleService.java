package com.auto_mendes.backend.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.VehicleRequestDTO;
import com.auto_mendes.backend.dto.VehicleResponseDTO;
import com.auto_mendes.backend.exception.NotFoundException;
import com.auto_mendes.backend.mapper.IVehicleMapper;
import com.auto_mendes.backend.model.Car;
import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.model.Motocycle;
import com.auto_mendes.backend.model.Vehicle;
import com.auto_mendes.backend.repository.ICarRepository;
import com.auto_mendes.backend.repository.IModelRepository;
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
	private IModelRepository modelRepository;
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

		Model modelFound = modelRepository.findByName(car.getModel().getName())
				.orElseThrow(() -> new NotFoundException("Modelo não encontrado."));

		car.setModel(modelFound);

		Car carSaved = carRepository.save(car);

		return vehicleMapper.toDTO(carSaved);
	}

	private VehicleResponseDTO registerMotocycle(VehicleRequestDTO dto) {
		Motocycle motocycle = vehicleMapper.toMotocycle(dto);

		vehicleValidation.validateMotocycle(motocycle);

		Model modelFound = modelRepository.findByName(motocycle.getModel().getName())
				.orElseThrow(() -> new NotFoundException("Modelo não encontrado."));

		motocycle.setModel(modelFound);

		Motocycle motocycleSaved = motocycleRepository.save(motocycle);

		return vehicleMapper.toDTO(motocycleSaved);
	}

	public VehicleResponseDTO updateVehicleById(String id, VehicleRequestDTO dto) {
		VehicleResponseDTO vehicleResponseDTO = null;

		switch (dto.getVehicleType().toString()) {
		case "CAR":
			vehicleResponseDTO = updateCarById(id, dto);
			break;
		case "MOTORCYCLE":
			vehicleResponseDTO = updateMotocycleById(id, dto);
			break;
		}
        
        return vehicleResponseDTO;
	}

	private VehicleResponseDTO updateCarById(String id, VehicleRequestDTO dto) {
		Car car = vehicleMapper.toCar(dto);

		vehicleValidation.validateCar(car);

		Car carFound = carRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Veiculo não encontrado."));

		Model modelFound = modelRepository.findByName(car.getModel().getName())
				.orElseThrow(() -> new NotFoundException("Modelo não encontrado."));
		
		BeanUtils.copyProperties(car, carFound, "id");
		
		carFound.setModel(modelFound);
		
		Car carSaved = carRepository.save(carFound);

		return vehicleMapper.toDTO(carSaved);
	}

	private VehicleResponseDTO updateMotocycleById(String id, VehicleRequestDTO dto) {
		Motocycle motocycle = vehicleMapper.toMotocycle(dto);
		
		vehicleValidation.validateMotocycle(motocycle);
		
		Motocycle motocycleFound = motocycleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Veiculo não encontrado."));

		Model modelFound = modelRepository.findByName(motocycle.getModel().getName())
				.orElseThrow(() -> new NotFoundException("Modelo não encontrado."));
		
		BeanUtils.copyProperties(motocycle, motocycleFound, "id");
		
		motocycleFound.setModel(modelFound);
		
		Motocycle motocycleSaved = motocycleRepository.save(motocycleFound);
		
		return vehicleMapper.toDTO(motocycleSaved);
	}

	public Page<VehicleResponseDTO> listVehicles(Pageable pageable) {
		Page<Vehicle> page = vehicleRepository.findAll(pageable);

		return page.map(vehicleMapper::toDTO);
	}
}