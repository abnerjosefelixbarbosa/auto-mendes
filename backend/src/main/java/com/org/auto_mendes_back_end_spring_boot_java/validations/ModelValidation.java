package com.org.auto_mendes_back_end_spring_boot_java.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Model;
import com.org.auto_mendes_back_end_spring_boot_java.exceptions.ValidationException;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.IModelRepository;

@Component
public class ModelValidation implements IModelValidation {
	@Autowired
	private IModelRepository modelRepository;
	
	public void validateModel(Model model) {
		boolean isExistsModel = modelRepository.existsByName(model.getName());
		
		if (isExistsModel) {
			throw new ValidationException("Nome do modelo existe");
		}
	}
}
