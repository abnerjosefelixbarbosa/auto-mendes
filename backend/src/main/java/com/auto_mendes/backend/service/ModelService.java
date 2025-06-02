package com.auto_mendes.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.ModelRequestDTO;
import com.auto_mendes.backend.dto.ModelResponseDTO;
import com.auto_mendes.backend.exception.NotFoundException;
import com.auto_mendes.backend.mapper.IModelMapper;
import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.repository.IModelRepository;
import com.auto_mendes.backend.validation.IModelValidation;

@Service
public class ModelService implements IModelService {
	@Autowired
	private IModelRepository modelRepository;
	@Autowired
	private IModelMapper modelMapper;
	@Autowired
	private IModelValidation modelValidation;
	
	public ModelResponseDTO registeModel(ModelRequestDTO dto) {
		Model model = modelMapper.toEntity(dto);
		
		modelValidation.validateModel(model);
		
		Model modelSaved = modelRepository.save(model);
		
		return modelMapper.toDTO(modelSaved);
	}

	public ModelResponseDTO updateModelById(String id, ModelRequestDTO dto) {
		Model model = modelMapper.toEntity(dto);
		
		modelValidation.validateModel(model);
		
		Model modelUpdated = modelRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Modelo não encontrado."));
		
		modelUpdated.setModel(model);
		
		Model modelSaved = modelRepository.save(modelUpdated);
		
		return modelMapper.toDTO(modelSaved);
	}

	public Page<ModelResponseDTO> listModels(Pageable pageable) {
		Page<Model> page = modelRepository.findAll(pageable);
		
		return page.map(modelMapper::toDTO);
	}
}