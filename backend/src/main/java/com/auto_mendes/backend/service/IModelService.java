package com.auto_mendes.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.auto_mendes.backend.dto.ModelRequestDTO;
import com.auto_mendes.backend.dto.ModelResponseDTO;

public interface IModelService {
	ModelResponseDTO registeModel(ModelRequestDTO dto);

	ModelResponseDTO updateModelById(String id, ModelRequestDTO dto);

	Page<ModelResponseDTO> listModels(Pageable pageable);
}