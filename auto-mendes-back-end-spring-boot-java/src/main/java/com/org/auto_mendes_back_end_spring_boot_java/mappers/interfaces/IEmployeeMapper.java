package com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequest;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponse;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;

public interface IEmployeeMapper {
	Employee toEmployee(EmployeeRequest request);
	EmployeeResponse toEmployeeResponse(Employee employee);
}