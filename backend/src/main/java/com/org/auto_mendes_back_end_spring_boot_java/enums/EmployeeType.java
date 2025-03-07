package com.org.auto_mendes_back_end_spring_boot_java.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EmployeeType {
	MANAGER("Manager"), DEPUTY_MANAGER("DeputyManager"), SALER("Saler");
	
	private String description;
}