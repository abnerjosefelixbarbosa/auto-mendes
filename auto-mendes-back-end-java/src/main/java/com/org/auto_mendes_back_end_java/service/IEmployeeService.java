package com.org.auto_mendes_back_end_java.service;

import com.org.auto_mendes_back_end_java.dto.RegisterEmployeeRequest;
import com.org.auto_mendes_back_end_java.dto.RegisterEmployeeResponse;

public interface IEmployeeService {
	RegisterEmployeeResponse registerEmployee(RegisterEmployeeRequest request);
}