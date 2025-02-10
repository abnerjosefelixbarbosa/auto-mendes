package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDto;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDto;

public interface EmployeeServiceInterface {
	public EmployeeResponseDto registerEmployee(EmployeeRequestDto request);
	public Page<EmployeeResponseDto> listEmployees(Pageable pageable);
}