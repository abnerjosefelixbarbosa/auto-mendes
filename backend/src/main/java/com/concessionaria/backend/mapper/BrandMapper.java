package com.concessionaria.backend.mapper;

import com.concessionaria.backend.dto.request.BrandRequestDTO;
import com.concessionaria.backend.dto.response.BrandResponseDTO;
import com.concessionaria.backend.entity.Brand;

public class BrandMapper {
	public static Brand toBrand(BrandRequestDTO request) {
		Brand brand = new Brand(null, request.name(), null);

		return brand;
	}

	public static BrandResponseDTO toBrandResponseDTO(Brand brand) {
		BrandResponseDTO response = new BrandResponseDTO(brand.getId(), brand.getName());

		return response;
	}
}
