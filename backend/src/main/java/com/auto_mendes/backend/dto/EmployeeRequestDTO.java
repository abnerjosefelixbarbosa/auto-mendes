package com.auto_mendes.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.auto_mendes.backend.enums.EmployeeType;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeRequestDTO {
	@NotNull(message = "Nome não deve ser nulo")
	@NotEmpty(message = "Nome não deve ser vazio")
	@Size(max = 100, message = "")
	private String name;
	private String email;
	private String registration;
	private String phone;
	private LocalDate birthDate;
	private BigDecimal commission;
	private EmployeeType employeeType;
}