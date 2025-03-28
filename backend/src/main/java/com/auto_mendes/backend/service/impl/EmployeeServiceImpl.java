package com.auto_mendes.backend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.mapper.EmployeeMapper;
import com.auto_mendes.backend.persistence.entity.AssistantManager;
import com.auto_mendes.backend.persistence.entity.Manager;
import com.auto_mendes.backend.persistence.entity.Saler;
import com.auto_mendes.backend.persistence.repository.AssistantManagerRepository;
import com.auto_mendes.backend.persistence.repository.ManagerRepository;
import com.auto_mendes.backend.persistence.repository.SalerRepository;
import com.auto_mendes.backend.service.EmployeeService;
import com.auto_mendes.backend.validation.EmployeeValidation;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private AssistantManagerRepository assistantManagerRepository;
	@Autowired
	private SalerRepository salerRepository;
	@Autowired
	private EmployeeValidation employeeValidation;
	private EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);

	@Transactional
	public EmployeeResponseDTO registerEmployee(EmployeeRequestDTO dto) {
		EmployeeResponseDTO employeeResponseDTO = null;

		switch (dto.employeeType().ordinal()) {
		case 0: {
			Manager manager = employeeMapper.toManager(dto);

			employeeValidation.validadeEmployee(manager);

			Manager managerSaved = managerRepository.save(manager);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(managerSaved);

			break;
		}
		case 1: {
			AssistantManager assistantManager = employeeMapper.toAssistantManager(dto);

			employeeValidation.validadeEmployee(assistantManager);

			AssistantManager assistantManagerSaved = assistantManagerRepository.save(assistantManager);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(assistantManagerSaved);

			break;
		}
		case 2: {
			Saler saler = employeeMapper.toSaler(dto);

			employeeValidation.validadeEmployee(saler);

			Saler salerSaved = salerRepository.save(saler);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(salerSaved);

			break;
		}
		}

		return employeeResponseDTO;
	}

	@Transactional
	public EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO dto) {
		EmployeeResponseDTO employeeResponseDTO = null;

		switch (dto.employeeType().ordinal()) {
		case 0: {
			Manager manager = employeeMapper.toManager(dto);

			employeeValidation.validadeEmployee(manager);

			Manager managerFound = managerRepository.findById(id).orElseThrow(() -> {
				throw new EntityNotFoundException("Id não encontrado.");
			});

			managerFound.setEmail(manager.getEmail());
			managerFound.setBirthDate(manager.getBirthDate());
			managerFound.setMatriculation(manager.getMatriculation());
			managerFound.setName(manager.getName());
			managerFound.setPhone(manager.getPhone());

			Manager managerSaved = managerRepository.save(managerFound);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(managerSaved);

			break;
		}
		case 1: {
			AssistantManager assistantManager = employeeMapper.toAssistantManager(dto);

			employeeValidation.validadeEmployee(assistantManager);

			AssistantManager assistantManagerFound = assistantManagerRepository.findById(id).orElseThrow(() -> {
				throw new EntityNotFoundException("Id não encontrado.");
			});

			assistantManagerFound.setEmail(assistantManager.getEmail());
			assistantManagerFound.setBirthDate(assistantManager.getBirthDate());
			assistantManagerFound.setMatriculation(assistantManager.getMatriculation());
			assistantManagerFound.setName(assistantManager.getName());
			assistantManagerFound.setPhone(assistantManager.getPhone());

			AssistantManager assistantManagerSaved = assistantManagerRepository.save(assistantManagerFound);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(assistantManagerSaved);

			break;
		}
		case 2: {
			Saler saler = employeeMapper.toSaler(dto);

			employeeValidation.validadeEmployee(saler);
			
			Saler salerFound = salerRepository.findById(id).orElseThrow(() -> {
				throw new EntityNotFoundException("Id não encontrado.");
			});

			salerFound.setEmail(saler.getEmail());
			salerFound.setBirthDate(saler.getBirthDate());
			salerFound.setMatriculation(saler.getMatriculation());
			salerFound.setName(saler.getName());
			salerFound.setPhone(saler.getPhone());
			salerFound.setCommission(saler.getCommission());

			Saler salerSaved = salerRepository.save(salerFound);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(salerSaved);

			break;
		}
		}

		return employeeResponseDTO;
	}
}