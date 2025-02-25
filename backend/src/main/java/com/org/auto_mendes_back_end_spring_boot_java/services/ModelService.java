package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.ModelRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.ModelResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Model;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.IModelMapper;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.IModelRepository;
import com.org.auto_mendes_back_end_spring_boot_java.validations.IModelValidation;

import jakarta.transaction.Transactional;

@Service
public class ModelService implements IModelService {
	@Autowired
	private IModelMapper modelMapper;
	@Autowired
	private IModelRepository modelRepository;
	@Autowired
	private IMarkService markService;
	@Autowired
	private IModelValidation modelValidation;
	
	@Transactional
	public ModelResponseDTO registerModel(ModelRequestDTO dto) {
		Model model = modelMapper.toModel(dto);
		
		modelValidation.validateModel(model);
		
		Mark mark = markService.findByName(model.getMark().getName());
		
		model.setMark(mark);
		
		model = modelRepository.save(model);
		
		return modelMapper.toModelResponseDTO(model);
	} 
}
