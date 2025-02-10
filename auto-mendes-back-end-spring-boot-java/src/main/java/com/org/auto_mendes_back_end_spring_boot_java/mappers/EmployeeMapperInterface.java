package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDto;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDto;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;

public interface EmployeeMapperInterface {
	Employee toEmployee(EmployeeRequestDto request);
	EmployeeResponseDto toEmployeeResponseDto(Employee employee);
}