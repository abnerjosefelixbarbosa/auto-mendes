package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDto;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDto;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.EmployeeMapperInterface;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.EmployeeRepositoryInterface;
import com.org.auto_mendes_back_end_spring_boot_java.validations.EmployeeValidationInterface;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	@Autowired
	private EmployeeRepositoryInterface employeeRepository;
	@Autowired
	private EmployeeValidationInterface employeeValidation;
	@Autowired
	private EmployeeMapperInterface employeeMapper;

	public EmployeeResponseDto registerEmployee(EmployeeRequestDto request) {
		employeeValidation.validateEmployee(request);
		
		Employee employee = employeeMapper.toEmployee(request);

		Employee response = employeeRepository.save(employee);

		return employeeMapper.toEmployeeResponseDto(response);
	}

	public Page<EmployeeResponseDto> listEmployees(Pageable pageable) {
		Page<Employee> responses = employeeRepository.findAll(pageable);
		
		return responses.map(employeeMapper::toEmployeeResponseDto);
	}

}