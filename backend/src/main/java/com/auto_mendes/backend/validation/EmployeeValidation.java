package com.auto_mendes.backend.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auto_mendes.backend.model.Employee;
import com.auto_mendes.backend.model.Manager;
import com.auto_mendes.backend.model.Saler;
import com.auto_mendes.backend.model.Submanager;
import com.auto_mendes.backend.repository.IEmployeeRepository;

@Component
public class EmployeeValidation implements IEmployeeValidation {
	@Autowired
	private IEmployeeRepository employeeRepository;

	public void validateEmployee(Employee employee) {
		boolean isExistsEmailOrRegistrationOrPhone = employeeRepository
				.existsByEmailOrMatriculationOrPhone(employee.getEmail(), employee.getMatriculation(), employee.getPhone());
		
		if (isExistsEmailOrRegistrationOrPhone) {
			throw new RuntimeException("Email, matrícula ou telefone não deve ser duplicados");
		}
	}
	
	public void validateManager(Manager manager) {
		boolean isExistsEmailOrRegistrationOrPhone = employeeRepository
				.existsByEmailOrMatriculationOrPhone(manager.getEmail(), manager.getMatriculation(), manager.getPhone());
		
		if (isExistsEmailOrRegistrationOrPhone) {
			throw new RuntimeException("Email, matrícula ou telefone não deve ser duplicados");
		}
	}
	
	public void validateSubmanager(Submanager submanager) {
		boolean isExistsEmailOrRegistrationOrPhone = employeeRepository
				.existsByEmailOrMatriculationOrPhone(submanager.getEmail(), submanager.getMatriculation(), submanager.getPhone());
		
		if (isExistsEmailOrRegistrationOrPhone) {
			throw new RuntimeException("Email, matrícula ou telefone não deve ser duplicados");
		}
	}
	
	public void validateSaler(Saler saler) {
		boolean isExistsEmailOrRegistrationOrPhone = employeeRepository
				.existsByEmailOrMatriculationOrPhone(saler.getEmail(), saler.getMatriculation(), saler.getPhone());
		
		if (isExistsEmailOrRegistrationOrPhone) {
			throw new RuntimeException("Email, matrícula ou telefone não deve ser duplicados");
		}
	}
}