package com.org.auto_mendes_back_end_java.entity;

public enum EmployeeType {
	Seller("SELLER"), Manager("MANAGER"), AssistantManager("ASSISTANT_MANAGER");
	
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