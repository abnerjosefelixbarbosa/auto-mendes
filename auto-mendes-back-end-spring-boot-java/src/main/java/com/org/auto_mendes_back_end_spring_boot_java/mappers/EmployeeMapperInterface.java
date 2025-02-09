package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;

public interface EmployeeMapperInterface {
	Employee toEmployee(EmployeeRequestDTO request);
	EmployeeResponseDTO toEmployeeResponseDTO(Employee employee);
}