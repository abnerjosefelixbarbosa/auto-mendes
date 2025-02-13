package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;

public interface EmployeeServiceInterface {
	Object registerEmployee(EmployeeRequestDTO request);
	Page<Object> listEmployees(Pageable pageable);
	Page<Object> listEmployeesByPosition(Pageable pageable, EmployeeType employeeType);
}