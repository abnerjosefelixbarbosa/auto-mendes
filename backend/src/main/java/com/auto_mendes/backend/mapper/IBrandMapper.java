package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.BrandRequestDTO;
import com.auto_mendes.backend.dto.BrandResponseDTO;
import com.auto_mendes.backend.model.Brand;

public interface IBrandMapper {
	Brand toEntity(BrandRequestDTO dto);
	
	BrandResponseDTO toDTO(Brand entity);
}