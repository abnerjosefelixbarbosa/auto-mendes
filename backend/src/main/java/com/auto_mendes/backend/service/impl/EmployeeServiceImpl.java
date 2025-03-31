package com.auto_mendes.backend.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.mapper.EmployeeMapper;
import com.auto_mendes.backend.model.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.model.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.model.entity.AssistantManager;
import com.auto_mendes.backend.model.entity.Manager;
import com.auto_mendes.backend.model.entity.Saler;
import com.auto_mendes.backend.model.enums.EmployeeType;
import com.auto_mendes.backend.repository.AssistantManagerRepository;
import com.auto_mendes.backend.repository.ManagerRepository;
import com.auto_mendes.backend.repository.SalerRepository;
import com.auto_mendes.backend.service.EmployeeService;
import com.auto_mendes.backend.validation.EmployeeValidation;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	private final ManagerRepository managerRepository;
	private final AssistantManagerRepository assistantManagerRepository;
	private final SalerRepository salerRepository;
	private final EmployeeValidation employeeValidation;
	private final EmployeeMapper employeeMapper;

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

	public Page<EmployeeResponseDTO> listEmployeeByType(EmployeeType type, Pageable pageable) {
		Page<EmployeeResponseDTO> page = null;

		switch (type.ordinal()) {
		case 0: {
			page = managerRepository.findAll(pageable).map(employeeMapper::toEmployeeResponseDTO);

			break;
		}
		case 1: {
			page = assistantManagerRepository.findAll(pageable).map(employeeMapper::toEmployeeResponseDTO);
			
			break;
		}
		case 2: {
			page = salerRepository.findAll(pageable).map(employeeMapper::toEmployeeResponseDTO);

			break;
		}
		}

		return page;
	}
}