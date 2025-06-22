package com.auto_mendes.backend.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.ModelRequestDTO;
import com.auto_mendes.backend.dto.ModelResponseDTO;
import com.auto_mendes.backend.exception.NotFoundException;
import com.auto_mendes.backend.model.Brand;
import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.repository.IBrandRepository;
import com.auto_mendes.backend.repository.IModelRepository;
import com.auto_mendes.backend.validation.IModelValidation;

@Service
public class ModelService implements IModelService {
	@Autowired
	private IModelRepository modelRepository;
	@Autowired
	private IModelValidation modelValidation;
	@Autowired
	private IBrandRepository brandRepository;
	
	public ModelResponseDTO registeModel(ModelRequestDTO dto) {
		Model model = new Model(dto);
		
		modelValidation.validateModel(model);
		
		Brand brandFound = brandRepository.findByName(model.getBrand().getName())
				.orElseThrow(() -> new NotFoundException("Marca não encontrada."));
		
		model.setBrand(brandFound);
		
		Model modelSaved = modelRepository.save(model);
		
		return new ModelResponseDTO(modelSaved);
	}

	public ModelResponseDTO updateModelById(String id, ModelRequestDTO dto) {
		Model model = new Model(dto);
		
		modelValidation.validateModel(model);
		
		Model modelFound = modelRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Modelo não encontrado."));
		
		Brand brandFound = brandRepository.findByName(model.getBrand().getName())
				.orElseThrow(() -> new NotFoundException("Marca não encontrada"));

		model.setBrand(brandFound);
		
		BeanUtils.copyProperties(model, modelFound, "id");
		
		Model modelSaved = modelRepository.save(modelFound);
		
		return new ModelResponseDTO(modelSaved);
	}
	
	

	public Page<ModelResponseDTO> listModels(Pageable pageable) {
		Page<Model> page = modelRepository.findAll(pageable);
		
		return page.map(ModelResponseDTO::new);
	}
}