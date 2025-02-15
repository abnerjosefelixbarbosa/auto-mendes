package com.org.auto_mendes_back_end_spring_boot_java.factories;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

public interface DTOFactoryInterface {
	EmployeeResponseDTO getEmployeeResponseDTO(Employee employee, Saler saler);
}