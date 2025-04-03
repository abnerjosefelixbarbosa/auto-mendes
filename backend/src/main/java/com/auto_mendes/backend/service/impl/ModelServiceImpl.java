package com.auto_mendes.backend.service.impl;

import org.springframework.stereotype.Service;

import com.auto_mendes.backend.mapper.ModelMapper;
import com.auto_mendes.backend.model.dto.request.ModelRequestDTO;
import com.auto_mendes.backend.model.dto.response.ModelResponseDTO;
import com.auto_mendes.backend.model.entity.Model;
import com.auto_mendes.backend.repository.ModelRepository;
import com.auto_mendes.backend.service.ModelService;
import com.auto_mendes.backend.validation.ModelValidation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
	private final ModelRepository modelRepository;
	private final ModelValidation modelValidation;
	private final ModelMapper modelMapper;
	
	public ModelResponseDTO registerModel(ModelRequestDTO dto) {
		Model model = modelMapper.toEntity(dto);
		
		return modelMapper.toDTO(model);
	}

	public ModelResponseDTO updateModelById(String id, ModelRequestDTO dto) {
		return null;
	}

	public ModelResponseDTO listModelByName(String name) {
		return null;
	}
}