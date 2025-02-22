package com.org.auto_mendes_back_end_spring_boot_java.factories;

import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.ModelRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.ModelResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Model;
import com.org.auto_mendes_back_end_spring_boot_java.factories.interfaces.IModelFactory;

@Component
public class ModelFactory implements IModelFactory {
	public Model createModel(ModelRequestDTO dto) {
		return new Model(dto);
	}
	
	public ModelResponseDTO createModel(Model model) {
		return new ModelResponseDTO(model);
	}
}
