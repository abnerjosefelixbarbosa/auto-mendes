package com.org.auto_mendes_back_end_spring_boot_java.factories;

import org.springframework.stereotype.Component;

import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

@Component
public class EmployeeFactory implements EmployeeFactoryInterface {
	public Employee getEmployee(EmployeeRequestDTO request) {
		Employee employee = new Employee();
		employee.setCpf(request.getCpf());
		employee.setEmail(request.getEmail());
		employee.setId(UlidCreator.getUlid().toString());
		employee.setMatriculation(request.getMatriculation());
		employee.setName(request.getName());
		employee.setSalary(request.getSalary());
		employee.setTelephone(request.getTelephone());

		return employee;
	}
	
	public Manager getManager(EmployeeRequestDTO request) {
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

	public DeputyManager getDeputyManager(EmployeeRequestDTO request) {
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

	public Saler getSaler(EmployeeRequestDTO request) {
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
}