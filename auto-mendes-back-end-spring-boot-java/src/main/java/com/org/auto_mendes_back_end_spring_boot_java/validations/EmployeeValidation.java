package com.org.auto_mendes_back_end_spring_boot_java.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.EmployeeRepositoryInterface;

@Component
public class EmployeeValidation implements EmployeeValidationInterface {
	@Autowired
	private EmployeeRepositoryInterface employeeRepository;

	public void validateEmployee(EmployeeRequestDTO employee) {
		if (employee.getEmployeeType().ordinal() != 2 && employee.getCommission() != null) {
			throw new RuntimeException("comissão não deve ser obrigatária");
		}
		
		if (employee.getSalary().scale() != 2) {
			throw new RuntimeException("salário deve ter dois dígitos");
		}
		
		if (employee.getEmployeeType().ordinal() == 2 && employee.getCommission() == null) {
			throw new RuntimeException("comissão deve ser obrigatária");
		}
		
		if (employee.getEmployeeType().ordinal() == 2 && employee.getCommission().scale() != 2) {
			throw new RuntimeException("comissão deve ter dois dígitos");
		}
		
		if (employeeRepository.existsByCpfOrEmailOrTelephoneOrMatriculation(employee.getCpf(), employee.getEmail(),
				employee.getTelephone(), employee.getMatriculation())) {
			throw new RuntimeException("cpf, email, telefone ou matrícula deve ser único");
		}
	}
}