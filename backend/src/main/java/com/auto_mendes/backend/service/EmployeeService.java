package com.auto_mendes.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.EmployeeResponseDTO;
import com.auto_mendes.backend.mapper.IEmployeeMapper;
import com.auto_mendes.backend.model.Employee;
import com.auto_mendes.backend.model.Manager;
import com.auto_mendes.backend.model.Saler;
import com.auto_mendes.backend.model.Submanager;
import com.auto_mendes.backend.repository.IEmployeeRepository;
import com.auto_mendes.backend.repository.IManagerRepository;
import com.auto_mendes.backend.repository.ISalerRepository;
import com.auto_mendes.backend.repository.ISubmanagerRepository;
import com.auto_mendes.backend.validation.IEmployeeValidation;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeRepository employeeRepository;
	@Autowired
	private IManagerRepository managerRepository;
	@Autowired
	private ISubmanagerRepository submanagerRepository;
	@Autowired
	private ISalerRepository salerRepository;
	@Autowired
	private IEmployeeMapper employeeMapper;
	@Autowired
	private IEmployeeValidation employeeValidation;
	
	public EmployeeResponseDTO registerEmployee(EmployeeRequestDTO dto) {
		EmployeeResponseDTO employeeResponseDTO = null;
		
		switch (dto.getEmployeeType().toString()) {
		case "MANAGER":
			employeeResponseDTO = registerManager(dto);
			break;
		case "SUBMANAGER":
			employeeResponseDTO = registerSubmanager(dto);
			break;	
		default:
			employeeResponseDTO = registerSaler(dto);
			break;
		}
		
		return employeeResponseDTO;
	}

	private EmployeeResponseDTO registerManager(EmployeeRequestDTO dto) {
		Manager manager = employeeMapper.toManager(dto);

		employeeValidation.validateManager(manager);

		Manager managerSaved = managerRepository.save(manager);

		return employeeMapper.toDTO(managerSaved);
	}
	
	private EmployeeResponseDTO registerSubmanager(EmployeeRequestDTO dto) {
		Submanager submanager = employeeMapper.toSubmanager(dto);

		employeeValidation.validateSubmanager(submanager);

		Submanager submanagerSaved = submanagerRepository.save(submanager);

		return employeeMapper.toDTO(submanagerSaved);
	}
	
	private EmployeeResponseDTO registerSaler(EmployeeRequestDTO dto) {
		Saler saler = employeeMapper.toSaler(dto);

		employeeValidation.validateSaler(saler);

		Saler salerSaved = salerRepository.save(saler);

		return employeeMapper.toDTO(salerSaved);
	}
	
	public EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO dto) {
EmployeeResponseDTO employeeResponseDTO = null;
		
		switch (dto.getEmployeeType().toString()) {
		case "MANAGER":
			employeeResponseDTO = registerManager(dto);
			break;
		case "SUBMANAGER":
			employeeResponseDTO = registerSubmanager(dto);
			break;	
		default:
			employeeResponseDTO = registerSaler(dto);
			break;
		}
		
		return employeeResponseDTO;
	}

	/*
	public EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO dto) {
		Employee employee = employeeMapper.toEntity(dto);

		employeeValidation.validateEmployee(employee);

		Employee employeeFound = employeeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Funcionário não encontrado."));

		employeeFound.updateEmployeeFields(employee, employeeFound);

		Employee employeeSaved = employeeRepository.save(employeeFound);

		return employeeMapper.toDTO(employeeSaved);
	}
	*/

	public Page<EmployeeResponseDTO> listEmployees(Pageable pageable) {
		Page<Employee> page = employeeRepository.findAll(pageable);

		return page.map(employeeMapper::toDTO);
	}
}