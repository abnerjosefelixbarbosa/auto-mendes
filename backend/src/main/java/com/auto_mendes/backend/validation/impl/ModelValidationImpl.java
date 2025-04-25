package com.auto_mendes.backend.validation.impl;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.repository.ModelRepository;
import com.auto_mendes.backend.validation.ModelValidation;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ModelValidationImpl implements ModelValidation {
	private final ModelRepository modelRepository;
	
	public void valiadteModel(Model model) {
		boolean isExistsName = modelRepository.existsByName(model.getName());
		
		if (isExistsName) 
			throw new EntityExistsException("Nome não deve existir.");
	}
}