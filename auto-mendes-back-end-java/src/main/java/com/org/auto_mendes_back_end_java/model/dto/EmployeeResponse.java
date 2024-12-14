package com.org.auto_mendes_back_end_java.model.dto;

import java.time.LocalDate;

import com.org.auto_mendes_back_end_java.model.entity.EmployeeType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
	private String id;
	private String name;
	private EmployeeType employeeType;
	private LocalDate birthDate;
	private String cpf;
	private String rg;
	private String email;
	private String contact;
}