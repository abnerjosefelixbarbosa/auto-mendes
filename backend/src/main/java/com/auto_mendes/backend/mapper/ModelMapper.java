package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.request.ModelRequestDTO;
import com.auto_mendes.backend.dto.response.ModelResponseDTO;
import com.auto_mendes.backend.entity.Brand;
import com.auto_mendes.backend.entity.Model;

public class ModelMapper {
	public static Model toModel(ModelRequestDTO dto) {
		Brand brand = new Brand(null, dto.brandName(), null);

		return new Model(null, dto.name(), brand, null);
	}

	public static ModelResponseDTO toModelResponseDTO(Model entity) {
		return new ModelResponseDTO(entity.getId(), entity.getName(), entity.getBrand().getName());
	}
}