package com.auto_mendes.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.auto_mendes.backend.dto.ModelRequestDTO;
import com.auto_mendes.backend.dto.ModelResponseDTO;

public interface ModelService {
	ModelResponseDTO registerModel(ModelRequestDTO dto);
	
	ModelResponseDTO updateModelById(String id, ModelRequestDTO dto);
	
	Page<ModelResponseDTO> listModelByName(String name, Pageable pageable);
}