package com.auto_mendes.backend.dto;

import org.springframework.beans.BeanUtils;

import com.auto_mendes.backend.enums.CustomerType;
import com.auto_mendes.backend.model.Customer;

import lombok.Data;

@Data
public class CustomerResponseDTO {
	private String id;
	private String document;
	private String name;
	private String email;
	private String phone;
	private CustomerType customerType;
	
	public CustomerResponseDTO(Customer entity) {
		BeanUtils.copyProperties(entity, this);
	}
}