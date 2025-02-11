package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import org.springframework.stereotype.Component;

import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

@Component
public class EmployeeMapper implements EmployeeMapperInterface {
	public Employee toEmployee(EmployeeRequestDTO request) {
		Employee employee = null;

		if (request.getEmployeeType().ordinal() == 0) {
			employee = new Manager(UlidCreator.getUlid().toString(), request.getName(), request.getCpf(),
					request.getEmail(), request.getTelephone(), request.getSalary(), request.getMatriculation(), null);
		} else if (request.getEmployeeType().ordinal() == 1) {
			employee = new DeputyManager(UlidCreator.getUlid().toString(), request.getName(), request.getCpf(),
					request.getEmail(), request.getTelephone(), request.getSalary(), request.getMatriculation(), null);
		} else {
			employee = new Saler(null, request.getName(), request.getCpf(), request.getEmail(), request.getTelephone(),
					request.getSalary(), request.getMatriculation(), null, request.getCommission());
		}

		return employee;
	}
	
	public EmployeeResponseDTO toEmployeeResponseDto(Employee employee) {
		return new EmployeeResponseDTO(employee.getId(), employee.getName(),
				employee.getCpf(), employee.getEmail(), employee.getTelephone(), employee.getSalary(),
				employee.getMatriculation(), null);
	}
}
