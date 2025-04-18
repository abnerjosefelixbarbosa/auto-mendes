package com.auto_mendes.backend.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.EmployeeResponseDTO;
import com.auto_mendes.backend.entity.AssistantManager;
import com.auto_mendes.backend.entity.Manager;
import com.auto_mendes.backend.entity.Saler;
import com.auto_mendes.backend.enums.EmployeeType;
import com.auto_mendes.backend.mapper.EmployeeMapper;
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
		
		if (dto.employeeType().ordinal() == 0) {
			Manager manager = employeeMapper.toManager(dto);

			employeeValidation.validadeEmployee(manager);

			Manager managerSaved = managerRepository.save(manager);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(managerSaved);
		}
		
		if (dto.employeeType().ordinal() == 1) {
			AssistantManager assistantManager = employeeMapper.toAssistantManager(dto);

			employeeValidation.validadeEmployee(assistantManager);

			AssistantManager assistantManagerSaved = assistantManagerRepository.save(assistantManager);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(assistantManagerSaved);
		}
		
		if (dto.employeeType().ordinal() == 2) {
			Saler saler = employeeMapper.toSaler(dto);

			employeeValidation.validadeEmployee(saler);

			Saler salerSaved = salerRepository.save(saler);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(salerSaved);
		}

		return employeeResponseDTO;
	}

	@Transactional
	public EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO dto) {
		EmployeeResponseDTO employeeResponseDTO = null;
		
		if (dto.employeeType().ordinal() == 0) {
			Manager manager = employeeMapper.toManager(dto);

			employeeValidation.validadeEmployee(manager);

			Manager managerFound = managerRepository.findById(id)
					.orElseThrow(() ->  new EntityNotFoundException("Gerente não encontrado."));

			managerFound.update(manager);
			
			Manager managerSaved = managerRepository.save(managerFound);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(managerSaved);
		}
		
		if (dto.employeeType().ordinal() == 1) {
			AssistantManager assistantManager = employeeMapper.toAssistantManager(dto);

			employeeValidation.validadeEmployee(assistantManager);

			AssistantManager assistantManagerFound = assistantManagerRepository.findById(id)
					.orElseThrow(() -> new EntityNotFoundException("Subgerente não encontrado."));

			assistantManagerFound.update(assistantManager);

			AssistantManager assistantManagerSaved = assistantManagerRepository.save(assistantManagerFound);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(assistantManagerSaved);
		}
		
		if (dto.employeeType().ordinal() == 2) {
			Saler saler = employeeMapper.toSaler(dto);

			employeeValidation.validadeEmployee(saler);

			Saler salerFound = salerRepository.findById(id)
					.orElseThrow(() -> new EntityNotFoundException("Vendedor não encontrado."));

			salerFound.update(saler);

			Saler salerSaved = salerRepository.save(salerFound);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(salerSaved);
		}

		return employeeResponseDTO;
	}

	public Page<EmployeeResponseDTO> listEmployeeByType(EmployeeType type, Pageable pageable) {
		Page<EmployeeResponseDTO> page = null;
		
		if (type.ordinal() == 0) {
			page = managerRepository.findAll(pageable).map(employeeMapper::toEmployeeResponseDTO);
		}
		
		if (type.ordinal() == 1) {
			page = assistantManagerRepository.findAll(pageable).map(employeeMapper::toEmployeeResponseDTO);
		}
		
		if (type.ordinal() == 2) {
			page = salerRepository.findAll(pageable).map(employeeMapper::toEmployeeResponseDTO);
		}

		return page;
	}
}