package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.model.dto.request.BrandRequestDTO;
import com.auto_mendes.backend.model.dto.response.BrandResponseDTO;
import com.auto_mendes.backend.model.entity.Brand;

public interface BrandMapper {
	Brand toBrand(BrandRequestDTO dto);
	
	BrandResponseDTO toBrandResponseDTO(Brand brand);
}