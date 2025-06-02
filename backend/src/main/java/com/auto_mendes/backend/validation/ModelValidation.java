package com.auto_mendes.backend.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.repository.IModelRepository;

@Component
public class ModelValidation implements IModelValidation {
	@Autowired
	private IModelRepository modelRepository;
	
	public void validateModel(Model model) {
	}
}
