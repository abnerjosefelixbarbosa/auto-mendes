package com.org.auto_mendes_back_end_java.model.entity;

public enum EmployeeType {
	SELLER("SELLER"), MANAGER("Manager"), ASSISTANT_MANAGER("ASSISTANT_MANAGER");
	
	private String value;

	private EmployeeType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}