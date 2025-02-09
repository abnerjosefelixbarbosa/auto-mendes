package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import org.springframework.stereotype.Component;

import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;

@Component
public class EmployeeMapper implements EmployeeMapperInterface {
	public Employee toEmployee(EmployeeRequestDTO request) {
		return new Employee(UlidCreator.getUlid().toString(), request.name(), request.cpf(), request.email(),
				request.telephone(), request.salary(), request.matriculation(), request.commission(),
				request.employeeType(), null);
	}

	public EmployeeResponseDTO toEmployeeResponseDTO(Employee employee) {
		return new EmployeeResponseDTO(employee.getId(), employee.getName(), employee.getCpf(), employee.getEmail(),
				employee.getTelephone(), employee.getSalary(), employee.getMatriculation(), employee.getCommission(),
				employee.getEmployeeType());
	}
}
