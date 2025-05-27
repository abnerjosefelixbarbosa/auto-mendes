package com.auto_mendes.backend.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auto_mendes.backend.model.Employee;
import com.auto_mendes.backend.repository.EmployeeRepository;

@Component
public class EmployeeValidation implements IEmployeeValidation {
	@Autowired
	private EmployeeRepository employeeRepository;

	public void validateEmployee(Employee employee) {
		boolean isExistsEmailOrRegistrationOrPhone = employeeRepository.existsByEmailOrRegistrationOrPhone(employee.getEmail(), employee.getRegistration(), employee.getPhone());
		
		if (employee.getEmployeeType().toString().equals("SALER") && employee.getCommission() == null) {
			throw new RuntimeException("Comissão não deve ser nula.");
		}
		if (employee.getCommission().scale() != 2) {
			throw new RuntimeException("Comissão deve ter 2 dígitos depois da vírgula.");
		}
		if (isExistsEmailOrRegistrationOrPhone) {
			throw new RuntimeException("Email, matrícula ou telefone não deve ser duplicados");
		}
	}
}