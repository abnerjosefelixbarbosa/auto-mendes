package com.concessionaria.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concessionaria.backend.entity.Employee;
import com.concessionaria.backend.entity.enums.EmployeeStatus;
import com.concessionaria.backend.entity.enums.EmployeeType;

public interface EmployeeService {
	Employee registerEmployee(Employee employee);

	Employee updateEmployeeById(String id, Employee employee);

	Employee findEmployeeById(String id);

	Page<Employee> listEmployees(String name, EmployeeStatus employeeStatus, EmployeeType employeeType,
			Pageable pageable);

	Employee findEmployeeByMatriculation(String matriculation);
}
