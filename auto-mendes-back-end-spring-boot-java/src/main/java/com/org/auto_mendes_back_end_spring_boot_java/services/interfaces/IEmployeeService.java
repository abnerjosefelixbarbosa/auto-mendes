package com.org.auto_mendes_back_end_spring_boot_java.services.interfaces;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequest;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponse;

public interface IEmployeeService {
	EmployeeResponse registerEmployee(EmployeeRequest request);
}