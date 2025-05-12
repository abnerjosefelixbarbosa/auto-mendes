package com.auto_mendes.backend.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.request.ModelRequestDTO;
import com.auto_mendes.backend.dto.response.ModelResponseDTO;
import com.auto_mendes.backend.mapper.ModelMapper;
import com.auto_mendes.backend.model.Brand;
import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.repository.ModelRepository;
import com.auto_mendes.backend.service.BrandService;
import com.auto_mendes.backend.service.ModelService;
import com.auto_mendes.backend.validation.ModelValidation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
	private final ModelRepository modelRepository;
	private final ModelValidation modelValidation;
	private final BrandService brandService;

	public ModelResponseDTO registerModel(ModelRequestDTO modelRequestDTO) {
		Model model = ModelMapper.toModel(modelRequestDTO);

		modelValidation.valiadteModel(model);

		Brand brandFound = brandService.findBrandByName(model.getBrand().getName());

		model.setBrand(brandFound);

		Model modelSaved = modelRepository.save(model);

		return ModelMapper.toModelResponseDTO(modelSaved);
	}

	public ModelResponseDTO updateModelById(String id, ModelRequestDTO modelRequestDTO) {
		Model model = ModelMapper.toModel(modelRequestDTO);

		modelValidation.valiadteModel(model);

		Brand brandFound = brandService.findBrandByName(model.getBrand().getName());

		model.setBrand(brandFound);

		Model modelFound = modelRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não encontrado."));

		modelFound.update(model);

		Model modelSaved = modelRepository.save(modelFound);

		return ModelMapper.toModelResponseDTO(modelSaved);
	}

	public Page<ModelResponseDTO> listModelByName(String name, Pageable pageable) {
		return modelRepository.findAllByNameContaining(name, pageable).map(ModelMapper::toModelResponseDTO);
	}

	public Page<ModelResponseDTO> listModel(Pageable pageable) {
		return modelRepository.findAll(pageable).map(ModelMapper::toModelResponseDTO);
	}
}