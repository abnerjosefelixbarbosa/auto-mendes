package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.EmployeeResponseDTO;
import com.auto_mendes.backend.model.Employee;
import com.auto_mendes.backend.model.Manager;
import com.auto_mendes.backend.model.Saler;
import com.auto_mendes.backend.model.Submanager;

public interface IEmployeeMapper {
	Manager toManager(EmployeeRequestDTO dto);
	
	Submanager toSubmanager(EmployeeRequestDTO dto);
	
	Saler toSaler(EmployeeRequestDTO dto);
	
	EmployeeResponseDTO toDTO(Employee employee);
}