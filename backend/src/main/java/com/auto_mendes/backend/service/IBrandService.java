package com.auto_mendes.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.auto_mendes.backend.dto.BrandRequestDTO;
import com.auto_mendes.backend.dto.BrandResponseDTO;

public interface IBrandService {
	BrandResponseDTO registerBrand(BrandRequestDTO dto);

	BrandResponseDTO updateBrandById(String id, BrandRequestDTO dto);

	Page<BrandResponseDTO> listBrands(Pageable pageable);
}