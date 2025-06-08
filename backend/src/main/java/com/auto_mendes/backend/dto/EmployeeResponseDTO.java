package com.auto_mendes.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.auto_mendes.backend.enums.EmployeeType;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}