package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import org.springframework.stereotype.Component;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequest;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponse;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces.IEmployeeMapper;

@Component
public class EmployeeMapper implements IEmployeeMapper {
	
	public Employee toEmployee(EmployeeRequest request) {
		Employee employee = new Employee();
		Ulid ulid = UlidCreator.getUlid();

		employee.setBirthDate(request.getBirthDate());
		employee.setCommission(request.getCommission());
		employee.setContact(request.getContact());
		employee.setCpf(request.getCpf());
		employee.setEmail(request.getEmail());
		employee.setEmployeeType(request.getEmployeeType());
		employee.setId(ulid.toString());
		employee.setMatriculation(request.getMatriculation());
		employee.setName(request.getName());
		
		return employee;
	}
	
	public EmployeeResponse toEmployeeResponse(Employee employee) {
		EmployeeResponse employeeResponse = new EmployeeResponse();

		employeeResponse.setBirthDate(employee.getBirthDate());
		employeeResponse.setCommission(employee.getCommission());
		employeeResponse.setContact(employee.getContact());
		employeeResponse.setCpf(employee.getCpf());
		employeeResponse.setEmail(employee.getEmail());
		employeeResponse.setEmployeeType(employee.getEmployeeType());
		employeeResponse.setId(employee.getId());
		employeeResponse.setMatriculation(employee.getMatriculation());
		employeeResponse.setName(employee.getName());
		
		return employeeResponse;
	}
}