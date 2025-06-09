package com.auto_mendes.backend.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeResponseListDTO {
	private String id;
	private String name;
	private String email;
	private String matriculation;
	private String phone;
	private Date birthDate;
	private String employeeType;
	private BigDecimal commission;
}