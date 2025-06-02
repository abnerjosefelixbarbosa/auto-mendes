package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.ModelRequestDTO;
import com.auto_mendes.backend.dto.ModelResponseDTO;
import com.auto_mendes.backend.model.Model;

public interface IModelMapper {
	Model toEntity(ModelRequestDTO dto);
	
	ModelResponseDTO toDTO(Model model);
}