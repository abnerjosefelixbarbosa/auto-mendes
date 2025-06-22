package com.auto_mendes.backend.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auto_mendes.backend.model.Employee;
import com.auto_mendes.backend.repository.IEmployeeRepository;

@Component
public class EmployeeValidation implements IEmployeeValidation {
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	public void validatemployee(Employee employee) {
		if (employee.getEmployeeType().toString().equals("SALER")) {
			if (employee.getCommission() == null || employee.getCommission().doubleValue() == 0) {
				throw new RuntimeException("Comissão não deve ser nulo ou 0.");
			}
			
			if (employee.getCommission().scale() != 2) {
				throw new RuntimeException("Comissão deve ter 2 dígitos depois da vírgula.");
			}
		} else {
			if (employee.getCommission() != null) {
				throw new RuntimeException("Comissão deve ser nulo.");
			}
		}
		
		boolean isExistsEmailOrMatriculationOrPhone = employeeRepository
				.existsByEmailOrMatriculationOrPhone(employee.getEmail(), employee.getMatriculation(), employee.getPhone());
		
		if (isExistsEmailOrMatriculationOrPhone) {
			throw new RuntimeException("Email, matrícula ou telefone não deve ser duplicados");
		}
	}
}