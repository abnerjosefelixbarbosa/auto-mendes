package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

public interface EmployeeMapperInterface {
	Employee toEmployee(EmployeeRequestDTO request);
	Saler toEmployeeSaler(EmployeeRequestDTO request);
	DeputyManager toEmployeeDeputyManager(EmployeeRequestDTO request);
	Manager toEmployeeManager(EmployeeRequestDTO request);
	EmployeeResponseDTO toEmployeeResponseDto(Employee employee);
	public EmployeeResponseDTO toEmployeeResponseDto(Saler saler);
}