package com.org.auto_mendes_back_end_java.mapper;

import com.org.auto_mendes_back_end_java.dto.EmployeeRequest;
import com.org.auto_mendes_back_end_java.dto.EmployeeResponse;
import com.org.auto_mendes_back_end_java.entity.Employee;

public interface IEmployeeMapper {
	Employee toEmployee(EmployeeRequest request);
	
	EmployeeResponse toEmployeeResponse(Employee employee);
}
