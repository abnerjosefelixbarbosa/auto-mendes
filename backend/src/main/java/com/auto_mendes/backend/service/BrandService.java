package com.auto_mendes.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.auto_mendes.backend.dto.BrandRequestDTO;
import com.auto_mendes.backend.dto.BrandResponseDTO;
import com.auto_mendes.backend.entity.Brand;

public interface BrandService {
	BrandResponseDTO registerBrand(BrandRequestDTO dto);
	
    BrandResponseDTO updateBrandByid(String id, BrandRequestDTO dto);
	
	Page<BrandResponseDTO> listBrandByName(String name, Pageable pageable);
	
	Brand findBrandByName(String name);
}