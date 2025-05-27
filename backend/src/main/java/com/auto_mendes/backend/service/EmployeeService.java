package com.auto_mendes.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.EmployeeResponseDTO;
import com.auto_mendes.backend.exception.NotFoundException;
import com.auto_mendes.backend.mapper.IEmployeeMapper;
import com.auto_mendes.backend.model.Employee;
import com.auto_mendes.backend.repository.IEmployeeRepository;
import com.auto_mendes.backend.validation.IEmployeeValidation;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeRepository employeeRepository;
	@Autowired
	private IEmployeeMapper employeeMapper;
	@Autowired
	private IEmployeeValidation employeeValidation;
	
	public EmployeeResponseDTO registerEmployee(EmployeeRequestDTO dto) {
		Employee employee = employeeMapper.toEntity(dto);
		
		employeeValidation.validateEmployee(employee);
		
		Employee employeeSaved = employeeRepository.save(employee);
		
		return employeeMapper.toDTO(employeeSaved);
	}

	public EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO dto) {
		Employee employee = employeeMapper.toEntity(dto);
		
		employeeValidation.validateEmployee(employee);
		
		Employee employeeFound = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Funcionário não encontrado."));
		
		employeeFound.setEmployee(employee);
		
		Employee employeeSaved = employeeRepository.save(employeeFound);
		
		return employeeMapper.toDTO(employeeSaved);
	}

	public Page<EmployeeResponseDTO> listEmployees(Pageable pageable) {
		Page<Employee> page = employeeRepository.findAll(pageable);
		
		return page.map(employeeMapper::toDTO);
	}
}