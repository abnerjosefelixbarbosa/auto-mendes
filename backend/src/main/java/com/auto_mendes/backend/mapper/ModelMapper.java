package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.request.ModelRequestDTO;
import com.auto_mendes.backend.dto.response.ModelResponseDTO;
import com.auto_mendes.backend.model.Brand;
import com.auto_mendes.backend.model.Model;

public class ModelMapper {
	public static Model toModel(ModelRequestDTO modelRequestDTO) {
		Brand brand = new Brand(null, modelRequestDTO.getBrandName(), null);

		return new Model(null, modelRequestDTO.getBrandName(), brand, null);
	}

	public static ModelResponseDTO toModelResponseDTO(Model model) {
		return new ModelResponseDTO(model.getId(), model.getName(), model.getBrand().getName());
	}
}