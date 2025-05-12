package com.auto_mendes.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.auto_mendes.backend.dto.request.ModelRequestDTO;
import com.auto_mendes.backend.dto.response.ModelResponseDTO;

public interface ModelService {
	ModelResponseDTO registerModel(ModelRequestDTO modelRequestDTO);
	
	ModelResponseDTO updateModelById(String id, ModelRequestDTO modelRequestDTO);
	
	Page<ModelResponseDTO> listModelByName(String name, Pageable pageable);

	Page<ModelResponseDTO> listModel(Pageable pageable);
}