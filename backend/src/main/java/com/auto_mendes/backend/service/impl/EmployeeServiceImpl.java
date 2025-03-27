package com.auto_mendes.backend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.entity.AssistantManager;
import com.auto_mendes.backend.entity.Manager;
import com.auto_mendes.backend.entity.Saler;
import com.auto_mendes.backend.mapper.EmployeeMapper;
import com.auto_mendes.backend.repository.AssistantManagerRepository;
import com.auto_mendes.backend.repository.ManagerRepository;
import com.auto_mendes.backend.repository.SalerRepository;
import com.auto_mendes.backend.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private AssistantManagerRepository assistantManagerRepository;
	@Autowired
	private SalerRepository salerRepository;
	private EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);

	@Transactional
	public EmployeeResponseDTO registerEmployee(EmployeeRequestDTO dto) {
		EmployeeResponseDTO employeeResponseDTO = null;

		switch (dto.employeeType().ordinal()) {
		case 0: {
			Manager manager = employeeMapper.toManager(dto);

			validadeEmployee(manager);

			Manager managerSaved = managerRepository.save(manager);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(managerSaved);

			break;
		}
		case 1: {
			AssistantManager assistantManager = employeeMapper.toAssistantManager(dto);

			validadeEmployee(assistantManager);

			AssistantManager assistantManagerSaved = assistantManagerRepository.save(assistantManager);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(assistantManagerSaved);

			break;
		}
		case 2: {
			Saler saler = employeeMapper.toSaler(dto);

			validadeEmployee(saler);

			Saler salerSaved = salerRepository.save(saler);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(salerSaved);

			break;
		}
		}

		return employeeResponseDTO;
	}

	private void validadeEmployee(Manager manager) {
		boolean isExists = managerRepository.existsByEmailOrMatriculationOrPhone(manager.getEmail(),
				manager.getMatriculation(), manager.getPhone());

		if (isExists) {
			throw new RuntimeException("Email, matrícula ou telefone não ser repedidos.");
		}
	}

	private void validadeEmployee(AssistantManager assistantManager) {
		boolean isExists = assistantManagerRepository.existsByEmailOrMatriculationOrPhone(assistantManager.getEmail(),
				assistantManager.getMatriculation(), assistantManager.getPhone());

		if (isExists) {
			throw new RuntimeException("Email, matrícula ou telefone não ser repedidos.");
		}
	}

	private void validadeEmployee(Saler saler) {
		boolean isExists = salerRepository.existsByEmailOrMatriculationOrPhone(saler.getEmail(),
				saler.getMatriculation(), saler.getPhone());
		
		if (isExists) {
			throw new RuntimeException("Email, matrícula ou telefone não ser repedidos.");
		}
		if (saler.getCommission().precision() > 20) {
			throw new RuntimeException("Comissão deve ter menos de 20 digitos antes da vírgula.");
		}
		if (saler.getCommission().scale() != 2) {
			throw new RuntimeException("Comissão deve ter 2 digitos depois da vírgula.");
		}
	}
}