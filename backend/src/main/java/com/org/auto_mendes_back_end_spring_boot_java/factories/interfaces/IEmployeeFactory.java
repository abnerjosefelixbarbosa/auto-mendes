package com.org.auto_mendes_back_end_spring_boot_java.factories.interfaces;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

public interface IEmployeeFactory {
	Manager createEmployeeManager(EmployeeRequestDTO dto);
	DeputyManager createEmployeeDeputyManager(EmployeeRequestDTO dto);
	Saler createEmployeeSaler(EmployeeRequestDTO dto);
	EmployeeResponseDTO createEmployeeResponseDTO(Manager manager);
	EmployeeResponseDTO createEmployeeResponseDTO(DeputyManager deputyManager);
	EmployeeResponseDTO createEmployeeResponseDTO(Saler saler);
}