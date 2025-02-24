package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

public interface IEmployeeMapper {
	Manager toManager(EmployeeRequestDTO dto);
	DeputyManager toDeputyManager(EmployeeRequestDTO dto);
	Saler toSaler(EmployeeRequestDTO dto);
	EmployeeResponseDTO toEmployeeResponseDTO(Manager manager);
	EmployeeResponseDTO toEmployeeResponseDTO(DeputyManager deputyManager);
	EmployeeResponseDTO toEmployeeResponseDTO(Saler saler);
}