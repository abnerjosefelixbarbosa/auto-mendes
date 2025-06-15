package com.auto_mendes.backend.dto;

import lombok.Data;

@Data
public class ModelResponseDTO {
	private String id;
	private String name;
	private BrandResponseDTO brand;
}