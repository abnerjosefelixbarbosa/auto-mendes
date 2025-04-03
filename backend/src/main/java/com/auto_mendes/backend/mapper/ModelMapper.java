package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.model.dto.request.ModelRequestDTO;
import com.auto_mendes.backend.model.dto.response.ModelResponseDTO;
import com.auto_mendes.backend.model.entity.Model;

public interface ModelMapper {
	Model toEntity(ModelRequestDTO dto);

	ModelResponseDTO toDTO(Model entity); 
}