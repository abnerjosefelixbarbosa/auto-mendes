package com.org.auto_mendes_back_end_java.validation;

import com.org.auto_mendes_back_end_java.dto.EmployeeRequest;

public interface IEmployeeValidation {
	void validateEmployee(EmployeeRequest request);
}