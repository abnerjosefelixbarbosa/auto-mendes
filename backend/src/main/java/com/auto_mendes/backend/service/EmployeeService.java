package com.auto_mendes.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.EmployeeResponseDTO;
import com.auto_mendes.backend.mapper.EmployeeMapper;
import com.auto_mendes.backend.model.Employee;
import com.auto_mendes.backend.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public EmployeeResponseDTO registerEmployee(EmployeeRequestDTO dto) {
		Employee employee = employeeMapper.toEntity(dto);
		
		return null;
	}

	public EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO dto) {
		Employee employee = employeeMapper.toEntity(dto);
		
		return null;
	}

	public Page<EmployeeResponseDTO> listEmployees(Pageable pageable) {
		
		return null;
	}
	
	
}