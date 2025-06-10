package com.auto_mendes.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.VehicleRequestDTO;
import com.auto_mendes.backend.dto.VehicleResponseDTO;
import com.auto_mendes.backend.mapper.IVehicleMapper;
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
		return null;
	}

	public VehicleResponseDTO updateVehicleById(String id, VehicleRequestDTO dto) {
		return null;
	}

	public Page<VehicleResponseDTO> listVehicles(Pageable pageable) {
		return null;
	}
}