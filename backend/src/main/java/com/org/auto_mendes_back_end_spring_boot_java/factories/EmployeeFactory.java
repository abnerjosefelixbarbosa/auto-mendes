package com.org.auto_mendes_back_end_spring_boot_java.factories;

import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;
import com.org.auto_mendes_back_end_spring_boot_java.factories.interfaces.IEmployeeFactory;

@Component
public class EmployeeFactory implements IEmployeeFactory {
	public Manager createEmployeeManager(EmployeeRequestDTO dto) {
		return new Manager(dto);
	}
	
	public DeputyManager createEmployeeDeputyManager(EmployeeRequestDTO dto) {
		return new DeputyManager(dto);
	}
	
	public Saler createEmployeeSaler(EmployeeRequestDTO dto) {
		return new Saler(dto);
	}
	
	public EmployeeResponseDTO createEmployeeResponseDTO(Manager manager) {
		return new EmployeeResponseDTO(manager);
	}

	public EmployeeResponseDTO createEmployeeResponseDTO(DeputyManager deputyManager) {
		return new EmployeeResponseDTO(deputyManager);
	}
	
	public EmployeeResponseDTO createEmployeeResponseDTO(Saler saler) {
		return new EmployeeResponseDTO(saler);
	}
}
