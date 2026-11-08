package com.concessionaria.backend.service.imp;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.concessionaria.backend.entity.Model;
import com.concessionaria.backend.entity.Vehicle;
import com.concessionaria.backend.entity.enums.TransmissionType;
import com.concessionaria.backend.entity.enums.VehicleStatus;
import com.concessionaria.backend.exception.ApplicationException;
import com.concessionaria.backend.exception.NotFoundException;
import com.concessionaria.backend.repository.VehicleRepository;
import com.concessionaria.backend.service.ModelService;
import com.concessionaria.backend.service.VehicleService;
import com.concessionaria.backend.specification.VehicleSpecification;

import jakarta.transaction.Transactional;

@Service
public class VehicleServiceImpl implements VehicleService {
	private final VehicleRepository vehicleRepository;
	private final ModelService modelService;

	public VehicleServiceImpl(VehicleRepository vehicleRepository, ModelService modelService) {
		this.vehicleRepository = vehicleRepository;
		this.modelService = modelService;
	}

	@Transactional
	public Vehicle registerVehicle(Vehicle vehicle) {
		validateVehicle(vehicle);

		Model modelFound = modelService.findModelByName(vehicle.getModel().getName());

		vehicle.setModel(modelFound);

		Vehicle savedVehicle = vehicleRepository.save(vehicle);

		return savedVehicle;
	}

	@Transactional
	public Vehicle updateVehicleById(String id, Vehicle vehicle) {
		validateVehicle(vehicle);

		Model foundModel = modelService.findModelByName(vehicle.getModel().getName());

		vehicle.setModel(foundModel);

		Vehicle foundVehicle = vehicleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Id deve ser existente."));

		BeanUtils.copyProperties(vehicle, foundModel, "id");

		vehicleRepository.save(foundVehicle);

		return foundVehicle;
	}

	public Vehicle findVehicleById(String id) {
		Vehicle foundVehicle = vehicleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Id deve ser existente."));

		return foundVehicle;
	}

	public Vehicle findVehicleByPlate(String plate) {
		Vehicle vehicle = vehicleRepository.findByPlate(plate)
				.orElseThrow(() -> new NotFoundException("Lista de itens deve ter placa de veiculo existente."));

		return vehicle;
	}

	public Page<Vehicle> listVehicles(TransmissionType transmissionType, VehicleStatus vehicleStatus,
			String color, String plate, Pageable pageable) {
		pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
				Sort.by(Sort.Direction.DESC, "price"));

		Page<Vehicle> page = vehicleRepository
				.findAll(VehicleSpecification.filter(transmissionType, vehicleStatus, color, plate), pageable);

		return page;
	}

	@Transactional
	public void updateVehicleByPlate(String plate, Vehicle vehicle) {
		Vehicle foundVehicle = findVehicleByPlate(plate);

		BeanUtils.copyProperties(vehicle, foundVehicle, "id");

		vehicleRepository.save(foundVehicle);
	}

	private void validateVehicle(Vehicle vehicle) {
		if (vehicleRepository.existsByPlate(vehicle.getPlate())) {
			throw new ApplicationException("Placa não deve ser repetida.");
		}

		if (vehicle.getPrice().scale() != 2) {
			throw new ApplicationException("Preço não deve ter dois dígitos.");
		}

		if (vehicle.getPrice().toString().equals("0.00")) {
			throw new ApplicationException("Preço não deve ser 0.00.");
		}
	}
}