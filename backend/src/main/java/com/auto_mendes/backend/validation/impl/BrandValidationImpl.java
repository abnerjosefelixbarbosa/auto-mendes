package com.auto_mendes.backend.validation.impl;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.entity.Brand;
import com.auto_mendes.backend.repository.BrandRepository;
import com.auto_mendes.backend.validation.BrandValidation;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BrandValidationImpl implements BrandValidation {
	private final BrandRepository brandRepository;

	public void validateBrand(Brand brand) {
		boolean isExists = brandRepository.existsByName(brand.getName());
		
		if (isExists) {
			throw new EntityExistsException("Nome não deve ser repetido.");
		} 
	}
}