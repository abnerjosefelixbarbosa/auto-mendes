package com.auto_mendes.backend.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.request.VehicleRequestDTO;
import com.auto_mendes.backend.dto.response.VehicleResponseDTO;
import com.auto_mendes.backend.mapper.VehicleMapper;
import com.auto_mendes.backend.model.Car;
import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.model.Motorcycle;
import com.auto_mendes.backend.model.Vehicle;
import com.auto_mendes.backend.repository.CarRepository;
import com.auto_mendes.backend.repository.ModelRepository;
import com.auto_mendes.backend.repository.MotorcycleRepository;
import com.auto_mendes.backend.repository.VehicleRepository;
import com.auto_mendes.backend.service.VehicleService;
import com.auto_mendes.backend.validation.VehicleValidation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
	private final VehicleValidation vehicleValidation;
	private final ModelRepository modelRepository;
	private final CarRepository carRepository;
	private final MotorcycleRepository motorcycleRepository;
	private final VehicleRepository vehicleRepository;

	public VehicleResponseDTO registerVehicle(VehicleRequestDTO vehicleRequestDTO) {
		VehicleResponseDTO response = null;

		if (vehicleRequestDTO.getVehicleType().ordinal() == 0) {
			Car car = VehicleMapper.toCar(vehicleRequestDTO);

			vehicleValidation.validateVehicle(car);

			Model modelFound = modelRepository.findByName(car.getModel().getName())
					.orElseThrow(() -> new EntityNotFoundException("Nome do modelo não encontrado."));

			car.setModel(modelFound);

			Car carSaved = carRepository.save(car);

			response = VehicleMapper.toVehicleResponseDTO(carSaved);
		}

		if (vehicleRequestDTO.getVehicleType().ordinal() == 1) {
			Motorcycle motorcycle = VehicleMapper.toMotorcycle(vehicleRequestDTO);

			vehicleValidation.validateVehicle(motorcycle);

			Model modelFound = modelRepository.findByName(motorcycle.getModel().getName())
					.orElseThrow(() -> new EntityNotFoundException("Nome do modelo não encontrado."));

			motorcycle.setModel(modelFound);

			Motorcycle motorcycleSaved = motorcycleRepository.save(motorcycle);

			response = VehicleMapper.toVehicleResponseDTO(motorcycleSaved);
		}

		return response;
	}

	public VehicleResponseDTO updateVehicleById(String id, VehicleRequestDTO vehicleRequestDTO) {
		VehicleResponseDTO response = null;

		if (vehicleRequestDTO.getVehicleType().ordinal() == 0) {
			Car car = VehicleMapper.toCar(vehicleRequestDTO);

			vehicleValidation.validateVehicle(car);

			Model modelFound = modelRepository.findByName(car.getModel().getName())
					.orElseThrow(() -> new EntityNotFoundException("Nome do modelo não encontrado."));

			car.setModel(modelFound);

			Car carFound = carRepository.findById(id)
					.orElseThrow(() -> new EntityNotFoundException("Id não encontrado"));

			carFound.update(car);

			Car carSaved = carRepository.save(carFound);

			response = VehicleMapper.toVehicleResponseDTO(carSaved);
		}

		if (vehicleRequestDTO.getVehicleType().ordinal() == 1) {
			Motorcycle motorcycle = VehicleMapper.toMotorcycle(vehicleRequestDTO);

			vehicleValidation.validateVehicle(motorcycle);

			Model modelFound = modelRepository.findByName(motorcycle.getModel().getName())
					.orElseThrow(() -> new EntityNotFoundException("Nome do modelo não encontrado."));

			motorcycle.setModel(modelFound);

			Motorcycle motorcycleFound = motorcycleRepository.findById(id)
					.orElseThrow(() -> new EntityNotFoundException("Id não encontrado"));

			motorcycleFound.update(motorcycle);

			Motorcycle motorcycleSaved = motorcycleRepository.save(motorcycleFound);

			response = VehicleMapper.toVehicleResponseDTO(motorcycleSaved);
		}

		return response;
	}

	public Page<VehicleResponseDTO> listVehicleByModel(String model, Pageable pageable) {
		Page<Vehicle> page = vehicleRepository.findAllByModelNameContaining(model, pageable);

		return page.map(VehicleMapper::toVehicleResponseDTO);
	}

	public Page<VehicleResponseDTO> listVehicle(Pageable pageable) {
		return vehicleRepository.findAll(pageable).map(null);
	}
}