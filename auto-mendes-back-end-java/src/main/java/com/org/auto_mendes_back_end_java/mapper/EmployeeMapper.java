package com.org.auto_mendes_back_end_java.mapper;

import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_java.dto.EmployeeRequest;
import com.org.auto_mendes_back_end_java.dto.EmployeeResponse;
import com.org.auto_mendes_back_end_java.entity.Employee;

@Component
public class EmployeeMapper implements IEmployeeMapper {

	public Employee toEmployee(EmployeeRequest request) {
		Employee employee = new Employee();
		
		employee.setName(request.name());
		employee.setCpf(request.cpf());
		employee.setEmployeeType(request.employeeType());
		employee.setBirthDate(request.birthDate());
		employee.setContact(request.contact());
		employee.setEmail(request.email());
		employee.setRg(request.rg());
		
		return employee;
	}
	
	public EmployeeResponse toEmployeeResponse(Employee employee) {
		EmployeeResponse response = new EmployeeResponse(
				employee.getId(),
				employee.getName(),
				employee.getEmployeeType(),
				employee.getBirthDate(),
				employee.getCpf(),
				employee.getRg(),
				employee.getEmail(),
				employee.getContact()
		);
		
		return response;
	}
	
}