package com.auto_mendes.backend.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.VehicleRequestDTO;
import com.auto_mendes.backend.dto.VehicleResponseDTO;
import com.auto_mendes.backend.exception.NotFoundException;
import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.model.Vehicle;
import com.auto_mendes.backend.repository.IModelRepository;
import com.auto_mendes.backend.repository.IVehicleRepository;
import com.auto_mendes.backend.validation.IVehicleValidation;

@Service
public class VehicleService implements IVehicleService {
	@Autowired
	private IVehicleRepository vehicleRepository;
	@Autowired
	private IModelRepository modelRepository;
	@Autowired
	private IVehicleValidation vehicleValidation;

	public VehicleResponseDTO registerVehicle(VehicleRequestDTO dto) {
		Vehicle vehicle = new Vehicle(dto);
		
		vehicleValidation.validateVehicle(vehicle);
		
		Model modelFound = modelRepository.findByName(vehicle.getModel().getName())
				.orElseThrow(() -> new NotFoundException("Modelo não encontrado."));
		
		vehicle.setModel(modelFound);
		
		Vehicle vehicleSaved = vehicleRepository.save(vehicle);

		return new VehicleResponseDTO(vehicleSaved);
	}

	public VehicleResponseDTO updateVehicleById(String id, VehicleRequestDTO dto) {
        Vehicle vehicle = new Vehicle(dto);
		
		vehicleValidation.validateVehicle(vehicle);
		
		Model modelFound = modelRepository.findByName(vehicle.getModel().getName())
				.orElseThrow(() -> new NotFoundException("Modelo não encontrado."));

		Vehicle vehicleFound = vehicleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Veiculo não encontrado."));
		
		BeanUtils.copyProperties(vehicle, vehicleFound, "id");
		
		vehicleFound.setModel(modelFound);
		
		Vehicle vehicleSaved = vehicleRepository.save(vehicleFound);
        
		return new VehicleResponseDTO(vehicleSaved);
	}

	public Page<VehicleResponseDTO> listVehicles(Pageable pageable) {
		Page<Vehicle> page = vehicleRepository.findAll(pageable);

		return page.map(VehicleResponseDTO::new);
	}
}