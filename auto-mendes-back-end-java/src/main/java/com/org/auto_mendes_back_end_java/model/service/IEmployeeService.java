package com.org.auto_mendes_back_end_java.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.org.auto_mendes_back_end_java.model.dto.EmployeeRegistrationRequest;
import com.org.auto_mendes_back_end_java.model.dto.EmployeeResponse;
import com.org.auto_mendes_back_end_java.model.dto.EmployeeUpdateRequest;

public interface IEmployeeService {
	EmployeeResponse registerEmployee(EmployeeRegistrationRequest request);
	
	EmployeeResponse updateEmployee(String cpf, EmployeeUpdateRequest request);
	
	EmployeeResponse searchEmployee(String cpf);
	
	Page<EmployeeResponse> listEmployeeByName(String name, Pageable pageable);
}