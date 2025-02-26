package com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

@Mapper
public interface IEmployeeMapper {
	@Mapping(target = "id", expression = "java(UlidCreator.getUlid().toString())")
	Manager toManager(EmployeeRequestDTO dto);

	@Mapping(target = "id", expression = "java(UlidCreator.getUlid().toString())")
	DeputyManager toDeputyManager(EmployeeRequestDTO dto);

	@Mapping(target = "id", expression = "java(UlidCreator.getUlid().toString())")
	@Mapping(target = "sales", ignore = true)
	Saler toSaler(EmployeeRequestDTO dto);

	@Mapping(target = "commission", ignore = true)
	EmployeeResponseDTO toEmployeeResponseDTO(Manager manager);

	@Mapping(target = "commission", ignore = true)
	EmployeeResponseDTO toEmployeeResponseDTO(DeputyManager deputyManager);

	EmployeeResponseDTO toEmployeeResponseDTO(Saler saler);
}