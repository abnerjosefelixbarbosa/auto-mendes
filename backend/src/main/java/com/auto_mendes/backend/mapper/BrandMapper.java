package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.request.BrandRequestDTO;
import com.auto_mendes.backend.dto.response.BrandResponseDTO;
import com.auto_mendes.backend.model.Brand;

public class BrandMapper {
	public static Brand toBrand(BrandRequestDTO brandRequestDTO) {
		return new Brand(null, brandRequestDTO.getName(), null);
	}

	public static BrandResponseDTO toBrandResponseDTO(Brand brand) {
		return new BrandResponseDTO(brand.getId(), brand.getName());
	}
}