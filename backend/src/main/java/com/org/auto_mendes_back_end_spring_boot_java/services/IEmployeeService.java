package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;

public interface IEmployeeService {
	EmployeeResponseDTO registerEmployee(EmployeeRequestDTO request);
	Page<EmployeeResponseDTO> listEmployees(Pageable pageable);
	Page<EmployeeResponseDTO> listEmployeesByPosition(Pageable pageable, EmployeeType employeeType);
	Page<EmployeeResponseDTO> listEmployeesByMatriculation(Pageable pageable, String matriculation);
	EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO request);
}