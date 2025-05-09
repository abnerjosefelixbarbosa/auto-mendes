package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.request.ModelRequestDTO;
import com.auto_mendes.backend.dto.response.ModelResponseDTO;
import com.auto_mendes.backend.model.Brand;
import com.auto_mendes.backend.model.Model;

public class ModelMapper {
	public static Model toModel(ModelRequestDTO data) {
		Brand brand = new Brand(null, data.getBrandName(), null);

		return new Model(null, data.getBrandName(), brand, null);
	}

	public static ModelResponseDTO toModelResponseDTO(Model data) {
		return new ModelResponseDTO(data.getId(), data.getName(), data.getBrand().getName());
	}
}