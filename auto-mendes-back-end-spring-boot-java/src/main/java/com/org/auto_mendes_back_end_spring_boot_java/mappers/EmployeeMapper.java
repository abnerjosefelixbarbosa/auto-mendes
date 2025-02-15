package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;
import com.org.auto_mendes_back_end_spring_boot_java.factories.DTOFactoryInterface;
import com.org.auto_mendes_back_end_spring_boot_java.factories.EmployeeFactoryInterface;

@Component
public class EmployeeMapper implements EmployeeMapperInterface {
	@Autowired
	private EmployeeFactoryInterface employeeFactory;
	@Autowired
	private DTOFactoryInterface dtoFactory;
	
	public Employee toEmployee(EmployeeRequestDTO request) {
		return employeeFactory.getEmployee(request);
	}
	
	public Saler toEmployeeSaler(EmployeeRequestDTO request) {
		return employeeFactory.getSaler(request);
	}
	
	public DeputyManager toEmployeeDeputyManager(EmployeeRequestDTO request) {
		return employeeFactory.getDeputyManager(request);
	}
	
	public Manager toEmployeeManager(EmployeeRequestDTO request) {
		return employeeFactory.getManager(request);
	}

	public EmployeeResponseDTO toEmployeeResponseDto(Employee employee, Saler saler) {	
		return dtoFactory.getEmployeeResponseDTO(employee, saler);
	}
}
