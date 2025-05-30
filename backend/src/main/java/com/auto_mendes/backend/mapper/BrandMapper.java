package com.auto_mendes.backend.mapper;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.dto.BrandRequestDTO;
import com.auto_mendes.backend.dto.BrandResponseDTO;
import com.auto_mendes.backend.model.Brand;

@Component
public class BrandMapper implements IBrandMapper {
	public Brand toEntity(BrandRequestDTO dto) {
		Brand brand = new Brand();
		brand.setName(dto.getName());
		
		return brand;
	}

	public BrandResponseDTO toDTO(Brand entity) {
		BrandResponseDTO brandResponseDTO = new BrandResponseDTO();
		brandResponseDTO.setId(entity.getId());
		brandResponseDTO.setName(entity.getName());
		
		return brandResponseDTO;
	}
}