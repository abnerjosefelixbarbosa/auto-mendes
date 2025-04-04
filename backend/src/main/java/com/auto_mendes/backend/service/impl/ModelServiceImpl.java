package com.auto_mendes.backend.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import jakarta.persistence.EntityNotFoundException;
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
		Model model = modelMapper.toModel(dto);

		modelValidation.valiadteModel(model);

		Brand brandFound = brandService
				.findBrandByName(model.getBrand().getName());

		model.setBrand(brandFound);
		
		Model modelFound = modelRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não encontrado."));
		
		modelFound.update(model);

		Model modelSaved = modelRepository.save(modelFound);

		return modelMapper.toModelResponseDTO(modelSaved);
	}

	public Page<ModelResponseDTO> listModelByName(String name, Pageable pageable) {
		return modelRepository.findAllByNameContaining(name, pageable)
				.map(modelMapper::toModelResponseDTO);
	}
}