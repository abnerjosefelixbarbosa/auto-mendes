package com.org.auto_mendes_back_end_spring_boot_java.validations;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDto;

public interface EmployeeValidationInterface {
	void validateEmployee(EmployeeRequestDto employee);
}