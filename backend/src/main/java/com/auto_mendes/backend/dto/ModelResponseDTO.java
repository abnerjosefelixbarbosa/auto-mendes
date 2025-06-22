package com.auto_mendes.backend.dto;

import org.springframework.beans.BeanUtils;

import com.auto_mendes.backend.model.Model;

import lombok.Data;

@Data
public class ModelResponseDTO {
	private String id;
	private String name;
	private String brandName;
	
	public ModelResponseDTO(Model model) {
		BeanUtils.copyProperties(model, this);
		this.brandName = model.getBrand().getName();
	}
}