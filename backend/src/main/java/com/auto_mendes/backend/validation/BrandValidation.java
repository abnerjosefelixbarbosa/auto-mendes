package com.auto_mendes.backend.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auto_mendes.backend.model.Brand;
import com.auto_mendes.backend.repository.IBrandRepository;

@Component
public class BrandValidation implements IBrandValidation {
	@Autowired
	private IBrandRepository brandRepository;

	public void validateBrand(Brand brand) {
		boolean isExistsName = brandRepository.existsByName(brand.getName());

		if (isExistsName) {
			throw new RuntimeException("Nome não deve ser duplicado.");
		}
	}

}