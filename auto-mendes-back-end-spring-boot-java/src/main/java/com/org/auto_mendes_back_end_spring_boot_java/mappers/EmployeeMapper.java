package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDto;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDto;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;

@Component
public class EmployeeMapper implements EmployeeMapperInterface {
	public Employee toEmployee(EmployeeRequestDto request) {
		Employee employee = new Employee();
		employee.setCpf(request.getCpf());
		employee.setEmail(request.getEmail());
		employee.setMatriculation(request.getMatriculation());
		employee.setName(request.getName());
		employee.setSalary(request.getSalary());
		employee.setTelephone(request.getTelephone());
		
		return employee;
	}

	public EmployeeResponseDto toEmployeeResponseDto(Employee employee) {
		EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
		employeeResponseDto.setCommission(null);
		employeeResponseDto.setCpf(null);
		employeeResponseDto.setEmail(null);
		employeeResponseDto.setId(null);
		employeeResponseDto.setMatriculation(null);
		employeeResponseDto.setName(null);
		employeeResponseDto.setSalary(null);
		employeeResponseDto.setTelephone(null);
		
		return employeeResponseDto;
	}
}
