package com.org.auto_mendes_back_end_java.model.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_java.model.dto.EmployeeRegistrationRequest;
import com.org.auto_mendes_back_end_java.model.dto.EmployeeUpdateRequest;
import com.org.auto_mendes_back_end_java.model.repository.IEmployeeRepository;

@Component
public class EmployeeValidation implements IEmployeeValidation {
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	public void validateEmployeeRegistrationRequest(EmployeeRegistrationRequest request) {
		boolean isExists = employeeRepository.existsByCpfOrRgOrEmailOrContact(request.getCpf(),
				request.getRg(),
				request.getEmail(),
				request.getContact());

		if (isExists)
			throw new RuntimeException("CPF, RG, email ou contact exists");
	}
	
	public void validateEmployeeUpdateRequest(EmployeeUpdateRequest request) {
		boolean isExists = employeeRepository.existsByEmailOrContact(request.getEmail(),
				request.getContact());

		if (isExists)
			throw new RuntimeException("Email ou contact exists");
	}
}