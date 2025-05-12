package com.auto_mendes.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.auto_mendes.backend.dto.request.BrandRequestDTO;
import com.auto_mendes.backend.dto.response.BrandResponseDTO;
import com.auto_mendes.backend.model.Brand;

public interface BrandService {
	BrandResponseDTO registerBrand(BrandRequestDTO brandRequestDTO);
	
    BrandResponseDTO updateBrandByid(String id, BrandRequestDTO brandRequestDTO);
	
	Page<BrandResponseDTO> listBrandByName(String name, Pageable pageable);
	
	Brand findBrandByName(String name);

	Page<BrandResponseDTO> listBrand(Pageable pageable);
}