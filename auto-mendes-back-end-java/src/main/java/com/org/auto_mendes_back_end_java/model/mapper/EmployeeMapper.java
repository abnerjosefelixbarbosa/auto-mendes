package com.org.auto_mendes_back_end_java.model.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_java.model.dto.EmployeeRegistrationRequest;
import com.org.auto_mendes_back_end_java.model.dto.EmployeeResponse;
import com.org.auto_mendes_back_end_java.model.entity.Employee;

@Component
public class EmployeeMapper implements IEmployeeMapper {

	public Employee toEmployee(EmployeeRegistrationRequest request) {
		Employee employee = new Employee();
		
		BeanUtils.copyProperties(request, employee);
		
		return employee;
	}
	
	public EmployeeResponse toEmployeeResponse(Employee employee) {
		EmployeeResponse response = new EmployeeResponse();
		
		BeanUtils.copyProperties(employee, response);
		
		return response;
	}
	
}