package com.org.auto_mendes_back_end_spring_boot_java.factories;

import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

@Component
public class DTOFactory implements DTOFactoryInterface {
	public EmployeeResponseDTO getEmployeeResponseDTO(Employee employee, Saler saler) {
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