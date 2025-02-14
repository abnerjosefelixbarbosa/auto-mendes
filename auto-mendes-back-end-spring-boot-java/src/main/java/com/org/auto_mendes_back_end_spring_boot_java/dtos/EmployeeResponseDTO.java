package com.org.auto_mendes_back_end_spring_boot_java.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {
	private String id;
	private String name;
	private String cpf;
	private String email;
	private String telephone;
	private BigDecimal salary;
	private String matriculation;
	private BigDecimal commission;
}