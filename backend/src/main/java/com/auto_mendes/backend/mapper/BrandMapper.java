package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.BrandRequestDTO;
import com.auto_mendes.backend.dto.BrandResponseDTO;
import com.auto_mendes.backend.entity.Brand;

public interface BrandMapper {
	Brand toBrand(BrandRequestDTO dto);
	
	BrandResponseDTO toBrandResponseDTO(Brand brand);
}