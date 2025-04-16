package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.ModelRequestDTO;
import com.auto_mendes.backend.dto.ModelResponseDTO;
import com.auto_mendes.backend.entity.Model;

public interface ModelMapper {
	Model toModel(ModelRequestDTO dto);

	ModelResponseDTO toModelResponseDTO(Model entity); 
}