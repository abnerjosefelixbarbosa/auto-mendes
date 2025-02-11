package com.org.auto_mendes_back_end_spring_boot_java.validations;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;

public interface EmployeeValidationInterface {
	void validateEmployee(EmployeeRequestDTO employee);
}