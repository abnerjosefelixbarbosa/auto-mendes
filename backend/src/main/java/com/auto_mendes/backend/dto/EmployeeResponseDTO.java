package com.auto_mendes.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.auto_mendes.backend.enums.EmployeeType;

import lombok.Data;

@Data
public class EmployeeResponseDTO {
	private String id;
	private String name;
	private String email;
	private String registration;
	private String phone;
	private LocalDate birthDate;
	private BigDecimal commission;
	private EmployeeType employeeType;
}