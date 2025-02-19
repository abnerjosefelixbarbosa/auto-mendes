package com.org.auto_mendes_back_end_spring_boot_java.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;
import com.org.auto_mendes_back_end_spring_boot_java.exceptions.ValidationException;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IEmployeeRepository;
import com.org.auto_mendes_back_end_spring_boot_java.validations.interfaces.IEmployeeValidation;

@Component
public class EmployeeValidation implements IEmployeeValidation {
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	public void validateEmployee(Manager manager) {
		if (manager.getSalary().scale() != 2) {
			throw new ValidationException("Salário deve ter dois dígitos");
		}
		
		if (employeeRepository.existsByCpfOrEmailOrTelephoneOrMatriculation(manager.getCpf(), manager.getEmail(),
				manager.getTelephone(), manager.getMatriculation())) {
			throw new ValidationException("CPF, email, telefone ou matrícula deve ser único");
		}
	}
	
	public void validateEmployee(DeputyManager deputyManager) {
		if (deputyManager.getSalary().scale() != 2) {
			throw new ValidationException("Salário deve ter dois dígitos");
		}
		
		if (employeeRepository.existsByCpfOrEmailOrTelephoneOrMatriculation(deputyManager.getCpf(), deputyManager.getEmail(),
				deputyManager.getTelephone(), deputyManager.getMatriculation())) {
			throw new ValidationException("CPF, email, telefone ou matrícula deve ser único");
		}
	}
	
	public void validateEmployee(Saler saler) {
		if (saler.getSalary().scale() != 2) {
			throw new ValidationException("Salário deve ter dois dígitos");
		}
		
		if (saler.getCommission() == null) {
			throw new ValidationException("Comissão deve ser obrigatária");
		}
		
		if (saler.getCommission().scale() != 2) {
			throw new ValidationException("Comissão deve ter dois dígitos");
		}
		
		if (employeeRepository.existsByCpfOrEmailOrTelephoneOrMatriculation(saler.getCpf(), saler.getEmail(),
				saler.getTelephone(), saler.getMatriculation())) {
			throw new ValidationException("CPF, email, telefone ou matrícula deve ser único");
		}
	}
}