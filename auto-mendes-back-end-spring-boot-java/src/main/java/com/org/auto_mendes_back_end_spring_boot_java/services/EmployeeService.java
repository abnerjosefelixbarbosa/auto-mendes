package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
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

	public EmployeeResponseDTO registerEmployee(EmployeeRequestDTO request) {
		Employee employee = employeeMapper.toEmployee(request);

		employeeValidation.validateEmployee(employee);

		employee = employeeRepository.save(employee);

		return employeeMapper.toEmployeeResponseDTO(employee);
	}

	public Page<EmployeeResponseDTO> listEmployees(Pageable pageable) {
		Page<Employee> employeePage = employeeRepository.findAll(pageable);
		
		return employeePage.map(employeeMapper::toEmployeeResponseDTO);
	}

}