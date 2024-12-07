package com.org.auto_mendes_back_end_java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_java.dto.RegisterEmployeeRequest;
import com.org.auto_mendes_back_end_java.dto.RegisterEmployeeResponse;
import com.org.auto_mendes_back_end_java.entity.Employee;
import com.org.auto_mendes_back_end_java.repository.IEmployeeRepository;

import jakarta.transaction.Transactional;

@Service 
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	
	@Override
	@Transactional
	public RegisterEmployeeResponse registerEmployee(RegisterEmployeeRequest request) {
		Employee employee = new Employee(request);
		
		validRegisterEmployee(employee);
		
		employee = employeeRepository.save(employee);
		
		RegisterEmployeeResponse response = new RegisterEmployeeResponse(employee);
		
		return response;
	}
	
	private void validRegisterEmployee(Employee employee) {
		boolean isExists = employeeRepository.existsByCpfOrRgOrEmailOrContact(
				employee.getCpf(),
				employee.getRg(),
				employee.getEmail(),
				employee.getContact()
		);
		
		if (isExists)
			throw new RuntimeException("CPF, RG, email ou contact  exists");
	}
}
