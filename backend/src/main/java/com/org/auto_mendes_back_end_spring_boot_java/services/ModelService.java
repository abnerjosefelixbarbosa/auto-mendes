package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.ModelRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.ModelResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Model;
import com.org.auto_mendes_back_end_spring_boot_java.exceptions.NotFoundException;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces.IModelMapper;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IModelRepository;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IMarkService;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IModelService;
import com.org.auto_mendes_back_end_spring_boot_java.validations.interfaces.IModelValidation;

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

	public Model findByName(String name) {
		return modelRepository.findByName(name)
				.orElseThrow(() -> new NotFoundException("Nome do modelo não foi encontrado"));
	}

	@Transactional
	public ModelResponseDTO updateModelById(String id, ModelRequestDTO dto) {
		Model model = modelMapper.toModel(dto);

		modelValidation.validateModel(model);

		Mark mark = markService.findByName(model.getMark().getName());

		Model modelFound = modelRepository.findById(id).orElseThrow(() -> new NotFoundException("ID não foi encontrado"));
		modelFound.setMark(mark);
		modelFound.setName(model.getName());

		model = modelRepository.save(modelFound);

		return modelMapper.toModelResponseDTO(model);
	}
}
