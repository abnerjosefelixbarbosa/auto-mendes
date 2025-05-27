package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.EmployeeResponseDTO;
import com.auto_mendes.backend.model.Employee;

public interface IEmployeeMapper {
	Employee toEntity(EmployeeRequestDTO dto);
	
	EmployeeResponseDTO toDTO(Employee employee);
}