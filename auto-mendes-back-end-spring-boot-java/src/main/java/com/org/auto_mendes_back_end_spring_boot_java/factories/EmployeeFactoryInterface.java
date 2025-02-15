package com.org.auto_mendes_back_end_spring_boot_java.factories;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

public interface EmployeeFactoryInterface {
	Manager getManager(EmployeeRequestDTO employeeRequestDTO);
	DeputyManager getDeputyManager(EmployeeRequestDTO employeeRequestDTO);
	Saler getSaler(EmployeeRequestDTO employeeRequestDTO);
}