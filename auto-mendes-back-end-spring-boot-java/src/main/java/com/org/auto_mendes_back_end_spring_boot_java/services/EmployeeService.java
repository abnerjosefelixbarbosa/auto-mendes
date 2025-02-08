package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.EmployeeRepositoryInterface;
import com.org.auto_mendes_back_end_spring_boot_java.validations.EmployeeValidationInterface;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	@Autowired
	private EmployeeRepositoryInterface employeeRepository;
	@Autowired
	private EmployeeValidationInterface employeeValidation;
	
	public EmployeeResponseDTO registerEmployee(EmployeeRequestDTO request) {
		Employee employee = new Employee(request);
		
		employeeValidation.validateEmployee(employee);
		
		employee = employeeRepository.save(employee);
		
		return new EmployeeResponseDTO(employee);
	}

	public Page<EmployeeResponseDTO> listEmployees(Pageable pageable) {
		var employees = employeeRepository.findAll(pageable);
		
		return employees.map(EmployeeResponseDTO::new);
	}

}