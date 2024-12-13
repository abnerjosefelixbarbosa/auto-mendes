package com.org.auto_mendes_back_end_java.model.validation;

import com.org.auto_mendes_back_end_java.model.dto.EmployeeRequest;

public interface IEmployeeValidation {
	void validateEmployee(EmployeeRequest request);
}