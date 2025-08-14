package com.auto_mendes.backend.dto;

import com.auto_mendes.backend.enums.CustomerType;

import lombok.Data;

@Data
public class CustomerResponseDTO {
	private String id;
	private String document;
	private String name;
	private String email;
	private String phone;
	private CustomerType customerType;
}