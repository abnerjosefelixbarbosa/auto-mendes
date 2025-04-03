package com.auto_mendes.backend.service;

import com.auto_mendes.backend.model.dto.request.ModelRequestDTO;
import com.auto_mendes.backend.model.dto.response.ModelResponseDTO;

public interface ModelService {
	ModelResponseDTO registerModel(ModelRequestDTO dto);
	
	ModelResponseDTO updateModelById(String id, ModelRequestDTO dto);
	
	ModelResponseDTO listModelByName(String name);
}