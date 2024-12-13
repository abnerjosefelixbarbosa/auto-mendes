package com.org.auto_mendes_back_end_java.model.validation;

import com.org.auto_mendes_back_end_java.model.dto.EmployeeRegistrationRequest;
import com.org.auto_mendes_back_end_java.model.dto.EmployeeUpdateRequest;

public interface IEmployeeValidation {
	void validateEmployeeRegistrationRequest(EmployeeRegistrationRequest request);
	
	void validateEmployeeUpdateRequest(EmployeeUpdateRequest request);
}