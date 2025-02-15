package com.org.auto_mendes_back_end_spring_boot_java.validations;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

public interface EmployeeValidationInterface {
	void validateEmployee(Employee employee, Saler saler, Integer type);
}