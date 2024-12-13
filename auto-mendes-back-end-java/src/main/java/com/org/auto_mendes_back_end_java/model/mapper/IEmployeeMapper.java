package com.org.auto_mendes_back_end_java.model.mapper;

import com.org.auto_mendes_back_end_java.model.dto.EmployeeRegistrationRequest;
import com.org.auto_mendes_back_end_java.model.dto.EmployeeResponse;
import com.org.auto_mendes_back_end_java.model.entity.Employee;

public interface IEmployeeMapper {
	Employee toEmployee(EmployeeRegistrationRequest request);
	
	EmployeeResponse toEmployeeResponse(Employee employee);
}
