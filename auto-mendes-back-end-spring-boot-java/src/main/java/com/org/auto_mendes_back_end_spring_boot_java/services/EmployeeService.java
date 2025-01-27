package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequest;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponse;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.exceptions.BusinessRuleException;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces.IEmployeeMapper;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.IEmployeeRepository;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeMapper employeeMapper;
	@Autowired
	private IEmployeeRepository employeeRepository;

	public EmployeeResponse registerEmployee(EmployeeRequest request) {
		Employee employee = employeeMapper.toEmployee(request);
		
		validateRegister(employee);

		employee = employeeRepository.save(employee);

		EmployeeResponse employeeResponse = employeeMapper.toEmployeeResponse(employee);

		return employeeResponse;
	}

	private void validateRegister(Employee employee) {
		boolean existsByCpfOrEmailOrMatriculationOrContact = employeeRepository
				.existsByCpfOrEmailOrMatriculationOrContact(employee.getCpf(), employee.getEmail(),
						employee.getMatriculation(), employee.getContact());

		if (existsByCpfOrEmailOrMatriculationOrContact) {
		    throw new BusinessRuleException("CPF, email, matrícula ou contato deve ser únicos");
		}

		if (employee.getEmployeeType().ordinal() == 2 && employee.getCommission() == null) {
			throw new BusinessRuleException("Comissão deve ser obrigatório");
		}

		if (employee.getEmployeeType().ordinal() == 2 && employee.getCommission().scale() > 1
				&& employee.getCommission().scale() < 2) {
			throw new BusinessRuleException("Comissão deve ter dois dígitos depois da vírgula");
		}
	}
}
