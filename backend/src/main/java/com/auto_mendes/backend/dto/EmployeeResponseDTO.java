package com.auto_mendes.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.auto_mendes.backend.enums.EmployeeType;
import com.auto_mendes.backend.model.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmployeeResponseDTO {
	private String id;
	private String name;
	private String email;
	private String matriculation;
	private String phone;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	private EmployeeType employeeType;
	private BigDecimal commission;
	
	public EmployeeResponseDTO(Employee employee) {
		BeanUtils.copyProperties(employee, this);
	}
}