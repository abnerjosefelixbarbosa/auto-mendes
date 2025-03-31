package com.auto_mendes.backend.mapper.impl;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.mapper.BrandMapper;
import com.auto_mendes.backend.model.dto.request.BrandRequestDTO;
import com.auto_mendes.backend.model.dto.response.BrandResponseDTO;
import com.auto_mendes.backend.model.entity.Brand;

@Component
public class BrandMapperImpl implements BrandMapper {
	public Brand toBrand(BrandRequestDTO dto) {
		return new Brand(null, dto.name(), null);
	}

	public BrandResponseDTO toBrandResponseDTO(Brand brand) {
		return new BrandResponseDTO(brand.getId(), brand.getName());
	}
}