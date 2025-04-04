package com.auto_mendes.backend.service.impl;

import org.springframework.stereotype.Service;

import com.auto_mendes.backend.mapper.ModelMapper;
import com.auto_mendes.backend.model.dto.request.ModelRequestDTO;
import com.auto_mendes.backend.model.dto.response.ModelResponseDTO;
import com.auto_mendes.backend.model.entity.Brand;
import com.auto_mendes.backend.model.entity.Model;
import com.auto_mendes.backend.repository.ModelRepository;
import com.auto_mendes.backend.service.BrandService;
import com.auto_mendes.backend.service.ModelService;
import com.auto_mendes.backend.validation.ModelValidation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
	private final ModelRepository modelRepository;
	private final ModelValidation modelValidation;
	private final ModelMapper modelMapper;
	private final BrandService brandService;

	public ModelResponseDTO registerModel(ModelRequestDTO dto) {
		Model model = modelMapper.toModel(dto);

		modelValidation.valiadteModel(model);

		Brand brandFound = brandService
				.findBrandByName(model.getBrand().getName());

		model.setBrand(brandFound);

		Model modelSaved = modelRepository.save(model);

		return modelMapper.toModelResponseDTO(modelSaved);
	}

	public ModelResponseDTO updateModelById(String id, ModelRequestDTO dto) {
		return null;
	}

	public ModelResponseDTO listModelByName(String name) {
		return null;
	}
}