package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.model.dto.request.ModelRequestDTO;
import com.auto_mendes.backend.model.dto.response.ModelResponseDTO;
import com.auto_mendes.backend.model.entity.Model;

public interface ModelMapper {
	Model toModel(ModelRequestDTO dto);

	ModelResponseDTO toModelResponseDTO(Model entity); 
}