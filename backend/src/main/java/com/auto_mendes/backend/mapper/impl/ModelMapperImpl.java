package com.auto_mendes.backend.mapper.impl;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.dto.ModelRequestDTO;
import com.auto_mendes.backend.dto.ModelResponseDTO;
import com.auto_mendes.backend.entity.Brand;
import com.auto_mendes.backend.entity.Model;
import com.auto_mendes.backend.mapper.ModelMapper;

@Component
public class ModelMapperImpl implements ModelMapper {
	public Model toModel(ModelRequestDTO dto) {
		Brand brand = new Brand(null, dto.brandName(), null);

		return new Model(null, dto.name(), brand, null);
	}

	public ModelResponseDTO toModelResponseDTO(Model entity) {
		return new ModelResponseDTO(entity.getId(), entity.getName(), entity.getBrand().getName());
	}
}