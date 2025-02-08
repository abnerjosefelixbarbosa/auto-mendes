package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;

public interface EmployeeServiceInterface {
	public EmployeeResponseDTO registerEmployee(EmployeeRequestDTO request);
	public Page<EmployeeResponseDTO> listEmployees(Pageable pageable);
}