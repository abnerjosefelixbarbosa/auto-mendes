package com.auto_mendes.backend.mapper;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.dto.ModelRequestDTO;
import com.auto_mendes.backend.dto.ModelResponseDTO;
import com.auto_mendes.backend.model.Brand;
import com.auto_mendes.backend.model.Model;

@Component
public class ModelMapper implements IModelMapper {
	public Model toEntity(ModelRequestDTO dto) {
		Brand brand = new Brand();
		brand.setName(dto.getBrandName());
		
		Model model = new Model();
		model.setName(dto.getName());
		model.setBrand(brand);
		
		return model;
	}

	public ModelResponseDTO toDTO(Model model) {
		ModelResponseDTO modelResponseDTO = new ModelResponseDTO();
		modelResponseDTO.setId(model.getId());
		modelResponseDTO.setName(model.getName());
		modelResponseDTO.setBrandId(model.getBrand().getId());
		modelResponseDTO.setBrandName(model.getBrand().getName());
		
		return modelResponseDTO;
	}
}