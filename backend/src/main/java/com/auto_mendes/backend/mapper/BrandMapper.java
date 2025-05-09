package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.request.BrandRequestDTO;
import com.auto_mendes.backend.dto.response.BrandResponseDTO;
import com.auto_mendes.backend.model.Brand;

public class BrandMapper {
	public static Brand toBrand(BrandRequestDTO data) {
		return new Brand(null, data.getName(), null);
	}

	public static BrandResponseDTO toBrandResponseDTO(Brand data) {
		return new BrandResponseDTO(data.getId(), data.getName());
	}
}