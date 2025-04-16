package com.auto_mendes.backend.mapper.impl;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.dto.BrandRequestDTO;
import com.auto_mendes.backend.dto.BrandResponseDTO;
import com.auto_mendes.backend.entity.Brand;
import com.auto_mendes.backend.mapper.BrandMapper;

@Component
public class BrandMapperImpl implements BrandMapper {
	public Brand toBrand(BrandRequestDTO dto) {
		return new Brand(null, dto.name(), null);
	}

	public BrandResponseDTO toBrandResponseDTO(Brand brand) {
		return new BrandResponseDTO(brand.getId(), brand.getName());
	}
}