package com.auto_mendes.backend.service;

import com.auto_mendes.backend.model.dto.request.BrandRequestDTO;
import com.auto_mendes.backend.model.dto.response.BrandResponseDTO;

public interface BrandService {
	BrandResponseDTO registerBrand(BrandRequestDTO dto);
}