package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import org.springframework.stereotype.Component;

import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

@Component
public class EmployeeMapper implements EmployeeMapperInterface {
	public Saler toEmployeeSaler(EmployeeRequestDTO request) {
		Saler saler = new Saler();
		saler.setId(UlidCreator.getUlid().toString());
		saler.setCpf(request.getCpf());
		saler.setCommission(request.getCommission());
		saler.setEmail(request.getEmail());
		saler.setMatriculation(request.getMatriculation());
		saler.setName(request.getName());
		saler.setSalary(request.getSalary());
		saler.setTelephone(request.getTelephone());
		
		return saler;
	}
	
	public DeputyManager toEmployeeDeputyManager(EmployeeRequestDTO request) {
		DeputyManager deputyManager = new DeputyManager();
		deputyManager.setCpf(request.getCpf());
		deputyManager.setEmail(request.getEmail());
		deputyManager.setId(UlidCreator.getUlid().toString());
		deputyManager.setMatriculation(request.getMatriculation());
		deputyManager.setName(request.getName());
		deputyManager.setSalary(request.getSalary());
		deputyManager.setTelephone(request.getTelephone());
		
		return deputyManager;
	}
	
	public Manager toEmployeeManager(EmployeeRequestDTO request) {
		Manager manager = new Manager();
		manager.setCpf(request.getCpf());
		manager.setEmail(request.getEmail());
		manager.setId(UlidCreator.getUlid().toString());
		manager.setMatriculation(request.getMatriculation());
		manager.setName(request.getName());
		manager.setSalary(request.getSalary());
		manager.setTelephone(request.getTelephone());
		
		return manager;
	}

	public EmployeeResponseDTO toEmployeeResponseDto(Employee employee, Saler saler) {
		EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
		employeeResponseDTO.setCpf(employee.getCpf());
		employeeResponseDTO.setEmail(employee.getEmail());
		employeeResponseDTO.setId(employee.getId());
		employeeResponseDTO.setMatriculation(employee.getMatriculation());
		employeeResponseDTO.setName(employee.getName());
		employeeResponseDTO.setSalary(employee.getSalary());
		employeeResponseDTO.setTelephone(employee.getTelephone());
		
		if (saler != null) {
			employeeResponseDTO.setCommission(saler.getCommission());
		}
		
		return employeeResponseDTO;
	}
}
