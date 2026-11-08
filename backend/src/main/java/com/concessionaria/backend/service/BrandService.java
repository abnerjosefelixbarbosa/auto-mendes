package com.concessionaria.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concessionaria.backend.entity.Brand;

public interface BrandService {
	Brand registerBrand(Brand brand);

	Brand updateBrandById(String id, Brand brand);

	Brand findBrandById(String id);

	Brand findByName(String name);

	Page<Brand> listBrands(String name, Pageable pageable);
}
