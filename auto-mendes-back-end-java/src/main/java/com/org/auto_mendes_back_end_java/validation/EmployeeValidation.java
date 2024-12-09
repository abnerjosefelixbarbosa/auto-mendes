package com.org.auto_mendes_back_end_java.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_java.dto.EmployeeRequest;
import com.org.auto_mendes_back_end_java.repository.IEmployeeRepository;

@Component
public class EmployeeValidation implements IEmployeeValidation {
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	public void validateEmployee(EmployeeRequest request) {
		boolean isExists = employeeRepository.existsByCpfOrRgOrEmailOrContact(request.cpf(), request.rg(),
				request.email(), request.contact());

		if (isExists)
			throw new RuntimeException("CPF, RG, email ou contact exists");
	}
}