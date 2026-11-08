package com.concessionaria.backend.service.imp;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.concessionaria.backend.entity.Brand;
import com.concessionaria.backend.exception.ApplicationException;
import com.concessionaria.backend.exception.NotFoundException;
import com.concessionaria.backend.repository.BrandRepository;
import com.concessionaria.backend.service.BrandService;
import com.concessionaria.backend.specification.BrandSpecification;

import jakarta.transaction.Transactional;

@Service
public class BrandServiceImpl implements BrandService {
	private final BrandRepository brandRepository;

	public BrandServiceImpl(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Transactional
	public Brand registerBrand(Brand brand) {
		validateBrand(brand);

		Brand savedBrand = brandRepository.save(brand);

		return savedBrand;
	}

	@Transactional
	public Brand updateBrandById(String id, Brand brand) {
		validateBrand(brand);

		Brand brandFound = brandRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Id deve ser existente."));

		BeanUtils.copyProperties(brand, brandFound, "id");

		brandRepository.save(brandFound);

		return brandFound;
	}

	public Brand findBrandById(String id) {
		Brand brandFound = brandRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Id deve ser existente."));

		return brandFound;
	}

	public Page<Brand> listBrands(String name, Pageable pageable) {
		Page<Brand> page = brandRepository.findAll(BrandSpecification.filter(name), pageable);

		return page;
	}

	public Brand findByName(String name) {
		return brandRepository.findByNameIgnoreCase(name)
				.orElseThrow(() -> new NotFoundException("Nome da marca deve ser existente."));
	}

	private void validateBrand(Brand brand) {
		if (isExistsByName(brand)) {
			throw new ApplicationException("Nome deve não deve ser repetido.");
		}
	}

	private boolean isExistsByName(Brand brand) {
		return brandRepository.existsByName(brand.getName());
	}
}
