package com.auto_mendes.backend.mapper;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.dto.BrandResponseDTO;
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
		BrandResponseDTO brandResponseDTO = new BrandResponseDTO();
		brandResponseDTO.setId(model.getBrand().getId());
		brandResponseDTO.setName(model.getBrand().getName());
		
		ModelResponseDTO modelResponseDTO = new ModelResponseDTO();
		modelResponseDTO.setId(model.getId());
		modelResponseDTO.setName(model.getName());
		modelResponseDTO.setDto(brandResponseDTO);
		
		return modelResponseDTO;
	}
}