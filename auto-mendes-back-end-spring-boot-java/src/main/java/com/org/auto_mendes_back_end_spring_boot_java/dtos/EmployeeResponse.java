package com.org.auto_mendes_back_end_spring_boot_java.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
	private String id;
	private String name;
	private String cpf;
	private LocalDate birthDate;
	private String email;
	private String contact;
	private String matriculation;
	private BigDecimal commission;
	private EmployeeType employeeType;
}