package com.org.auto_mendes_back_end_spring_boot_java.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.EmployeeRepositoryInterface;

@Component
public class EmployeeValidation implements EmployeeValidationInterface {
	@Autowired
	private EmployeeRepositoryInterface employeeRepository;
	
	public void validateEmployee(Employee employee, Saler saler, Integer type) {
		if (type != 2 && saler.getCommission() != null) {
			throw new RuntimeException("comissão não deve ser obrigatária");
		}
		
		if (employee.getSalary().scale() != 2) {
			throw new RuntimeException("salário deve ter dois dígitos");
		}
		
		if (type == 2 && saler.getCommission() == null) {
			throw new RuntimeException("comissão deve ser obrigatária");
		}
		
		if (type == 2 && saler.getCommission().scale() != 2) {
			throw new RuntimeException("comissão deve ter dois dígitos");
		}
		
		if (employeeRepository.existsByCpfOrEmailOrTelephoneOrMatriculation(employee.getCpf(), employee.getEmail(),
				employee.getTelephone(), employee.getMatriculation())) {
			throw new RuntimeException("cpf, email, telefone ou matrícula deve ser único");
		}
	}
}