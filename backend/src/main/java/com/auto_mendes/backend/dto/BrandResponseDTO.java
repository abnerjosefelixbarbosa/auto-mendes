package com.auto_mendes.backend.dto;

import org.springframework.beans.BeanUtils;

import com.auto_mendes.backend.model.Brand;

import lombok.Data;

@Data
public class BrandResponseDTO {
	private String id;
	private String name;
	
	public BrandResponseDTO(Brand brand) {
		BeanUtils.copyProperties(brand, this);
	}
}