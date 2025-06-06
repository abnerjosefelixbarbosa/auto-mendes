package com.auto_mendes.backend.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auto_mendes.backend.model.Employee;
import com.auto_mendes.backend.repository.IEmployeeRepository;

@Component
public class EmployeeValidation implements IEmployeeValidation {
	@Autowired
	private IEmployeeRepository employeeRepository;

	public void validateEmployee(Employee employee) {
		boolean isExistsEmailOrRegistrationOrPhone = employeeRepository
				.existsByEmailOrMatriculationOrPhone(employee.getEmail(), employee.getMatriculation(), employee.getPhone());
		
		/*
		if (employee.getEmployeeType().toString().equals("SALER")) {
			if (employee.getCommission() == null) {
				throw new RuntimeException("Comissão não deve ser nulo.");
			}
			
			if (employee.getCommission().scale() != 2) {
				throw new RuntimeException("Comissão deve ter 2 dígitos depois da vírgula.");
			}
			
			if (employee.getCommission().toString().equals("0.00")) {
				throw new RuntimeException("Comissão não deve ser 0.00.");
			}
		}
		*/
		
		if (isExistsEmailOrRegistrationOrPhone) {
			throw new RuntimeException("Email, matrícula ou telefone não deve ser duplicados");
		}
	}
}