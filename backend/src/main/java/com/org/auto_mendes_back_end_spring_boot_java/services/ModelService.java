package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.ModelRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.ModelResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Model;
import com.org.auto_mendes_back_end_spring_boot_java.factories.interfaces.IModelFactory;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IModelRepository;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IMarkService;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IModelService;

import jakarta.transaction.Transactional;

@Service
public class ModelService implements IModelService {
	@Autowired
	private IModelFactory modelFactory;
	@Autowired
	private IModelRepository modelRepository;
	@Autowired
	private IMarkService markService;
	
	@Transactional
	public ModelResponseDTO registerModel(ModelRequestDTO dto) {
		Model model = modelFactory.createModel(dto);
		
		Mark mark = markService.findByName(model.getMark().getName());
		
		model.setMark(mark);
		
		model = modelRepository.save(model);
		
		return modelFactory.creatMarkResponseDTO(model);
	} 
}
