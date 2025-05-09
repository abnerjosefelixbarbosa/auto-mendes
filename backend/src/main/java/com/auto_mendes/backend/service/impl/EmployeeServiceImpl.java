package com.auto_mendes.backend.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.enums.EmployeeType;
import com.auto_mendes.backend.mapper.EmployeeMapper;
import com.auto_mendes.backend.model.AssistantManager;
import com.auto_mendes.backend.model.Manager;
import com.auto_mendes.backend.model.Saler;
import com.auto_mendes.backend.repository.AssistantManagerRepository;
import com.auto_mendes.backend.repository.EmployeeRepository;
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
	private final EmployeeRepository employeeRepository;
	private final EmployeeValidation employeeValidation;

	@Transactional
	public EmployeeResponseDTO registerEmployee(EmployeeRequestDTO data) {
		EmployeeResponseDTO employeeResponseDTO = null;

		if (data.getEmployeeType().ordinal() == 0) {
			Manager manager = EmployeeMapper.toManager(data);

			employeeValidation.validadeEmployee(manager);

			Manager managerSaved = managerRepository.save(manager);

			employeeResponseDTO = EmployeeMapper.toEmployeeResponseDTO(managerSaved);
		}

		if (data.getEmployeeType().ordinal() == 1) {
			AssistantManager assistantManager = EmployeeMapper.toAssistantManager(data);

			employeeValidation.validadeEmployee(assistantManager);

			AssistantManager assistantManagerSaved = assistantManagerRepository.save(assistantManager);

			employeeResponseDTO = EmployeeMapper.toEmployeeResponseDTO(assistantManagerSaved);
		}

		if (data.getEmployeeType().ordinal() == 2) {
			Saler saler = EmployeeMapper.toSaler(data);

			employeeValidation.validadeEmployee(saler);

			Saler salerSaved = salerRepository.save(saler);

			employeeResponseDTO = EmployeeMapper.toEmployeeResponseDTO(salerSaved);
		}

		return employeeResponseDTO;
	}

	@Transactional
	public EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO data) {
		EmployeeResponseDTO employeeResponseDTO = null;

		if (data.getEmployeeType().ordinal() == 0) {
			Manager manager = EmployeeMapper.toManager(data);

			employeeValidation.validadeEmployee(manager);

			Manager managerFound = managerRepository.findById(id)
					.orElseThrow(() -> new EntityNotFoundException("Gerente não encontrado."));

			managerFound.update(manager);

			Manager managerSaved = managerRepository.save(managerFound);

			employeeResponseDTO = EmployeeMapper.toEmployeeResponseDTO(managerSaved);
		}

		if (data.getEmployeeType().ordinal() == 1) {
			AssistantManager assistantManager = EmployeeMapper.toAssistantManager(data);

			employeeValidation.validadeEmployee(assistantManager);

			AssistantManager assistantManagerFound = assistantManagerRepository.findById(id)
					.orElseThrow(() -> new EntityNotFoundException("Subgerente não encontrado."));

			assistantManagerFound.update(assistantManager);

			AssistantManager assistantManagerSaved = assistantManagerRepository.save(assistantManagerFound);

			employeeResponseDTO = EmployeeMapper.toEmployeeResponseDTO(assistantManagerSaved);
		}

		if (data.getEmployeeType().ordinal() == 2) {
			Saler saler = EmployeeMapper.toSaler(data);

			employeeValidation.validadeEmployee(saler);

			Saler salerFound = salerRepository.findById(id)
					.orElseThrow(() -> new EntityNotFoundException("Vendedor não encontrado."));

			salerFound.update(saler);

			Saler salerSaved = salerRepository.save(salerFound);

			employeeResponseDTO = EmployeeMapper.toEmployeeResponseDTO(salerSaved);
		}

		return employeeResponseDTO;
	}

	public Page<EmployeeResponseDTO> listEmployeeByType(EmployeeType type, Pageable pageable) {
		Page<EmployeeResponseDTO> page = null;

		if (type.ordinal() == 0) {
			page = managerRepository.findAll(pageable).map(EmployeeMapper::toEmployeeResponseDTO);
		}

		if (type.ordinal() == 1) {
			page = assistantManagerRepository.findAll(pageable).map(EmployeeMapper::toEmployeeResponseDTO);
		}

		if (type.ordinal() == 2) {
			page = salerRepository.findAll(pageable).map(EmployeeMapper::toEmployeeResponseDTO);
		}

		return page;
	}
	
	public Page<EmployeeResponseDTO> listEmployee(Pageable pageable) {
		return employeeRepository.listEmployee(pageable);
	}
}