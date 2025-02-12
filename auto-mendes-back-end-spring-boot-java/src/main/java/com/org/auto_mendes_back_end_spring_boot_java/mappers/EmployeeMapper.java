package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

@Component
public class EmployeeMapper implements EmployeeMapperInterface {
	public Saler toEmployeeSaler(EmployeeRequestDTO request) {
		return new Saler(request);
	}
	
	public DeputyManager toEmployeeDeputyManager(EmployeeRequestDTO request) {
		return new DeputyManager(request);
	}
	
	public Manager toEmployeeManager(EmployeeRequestDTO request) {
		return new Manager(request);
	}

	public EmployeeResponseDTO toEmployeeResponseDto(Employee employee, BigDecimal commission) {
		return new EmployeeResponseDTO(employee, commission);
	}
}
