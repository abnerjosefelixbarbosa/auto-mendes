package com.auto_mendes.backend.service.impl;

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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	private final ManagerRepository managerRepository;
	private final AssistantManagerRepository assistantManagerRepository;
	private final SalerRepository salerRepository;
	private final EmployeeMapper employeeMapper;

	public EmployeeResponseDTO registerEmployee(EmployeeRequestDTO request) {
		EmployeeResponseDTO response = null;

		switch (request.employeeType().ordinal()) {
		case 0: {
			Manager manager = employeeMapper.toManager(request);
			
			manager = managerRepository.save(manager);
			
			response = employeeMapper.toEmployeeResponseDTO(manager);
		}
		case 1: {
			AssistantManager assistantManager = employeeMapper.toAssistantManager(request);
		
			assistantManager = assistantManagerRepository.save(assistantManager);
			
			response = employeeMapper.toEmployeeResponseDTO(assistantManager);
		}
		case 2: {
			Saler saler = employeeMapper.toSaler(request);
			
			validadeEmployee(saler);
			
			saler = salerRepository.save(saler);
			
			response = employeeMapper.toEmployeeResponseDTO(saler);
		}
		}

		return response;
	}
	
	private void validadeEmployee(Saler saler) {
		if (saler.getCommission().precision() > 20) {
			throw new RuntimeException("Comissoa deve ter menos de 20 digitos antes da virgula.");
		}
		if (saler.getCommission().scale() != 2) {
			throw new RuntimeException("Comissoa deve ter 2 digitos depois da virgula.");
		}
	}
}