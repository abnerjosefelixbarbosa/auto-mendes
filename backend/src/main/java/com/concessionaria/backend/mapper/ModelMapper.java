package com.concessionaria.backend.mapper;

import com.concessionaria.backend.dto.request.ModelRequestDTO;
import com.concessionaria.backend.dto.response.BrandResponseDTO;
import com.concessionaria.backend.dto.response.ModelResponseDTO;
import com.concessionaria.backend.entity.Brand;
import com.concessionaria.backend.entity.Model;

public class ModelMapper {
	public static Model toModel(ModelRequestDTO request) {
		Brand brand = new Brand(null, request.brandName(), null);

		Model model = new Model(null, request.name(), brand, null);

		return model;
	}

	public static ModelResponseDTO toModelResponseDTO(Model model) {
		Brand brand = model.getBrand();

		BrandResponseDTO brandResponseDTO = new BrandResponseDTO(brand.getId(), brand.getName());

		ModelResponseDTO response = new ModelResponseDTO(model.getId(), model.getName(), brandResponseDTO);

		return response;
	}
}
