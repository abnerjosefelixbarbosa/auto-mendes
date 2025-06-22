package com.auto_mendes.backend.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.BrandRequestDTO;
import com.auto_mendes.backend.dto.BrandResponseDTO;
import com.auto_mendes.backend.exception.NotFoundException;
import com.auto_mendes.backend.model.Brand;
import com.auto_mendes.backend.repository.IBrandRepository;
import com.auto_mendes.backend.validation.IBrandValidation;

@Service
public class BrandService implements IBrandService {
	@Autowired
	private IBrandValidation brandValidation;
	@Autowired
	private IBrandRepository brandRepository;

	public BrandResponseDTO registerBrand(BrandRequestDTO dto) {
		Brand brand = new Brand(dto);

		brandValidation.validateBrand(brand);

		Brand brandSaved = brandRepository.save(brand);

		return new BrandResponseDTO(brandSaved);
	}

	public BrandResponseDTO updateBrandById(String id, BrandRequestDTO dto) {
		Brand brand = new Brand(dto);

		brandValidation.validateBrand(brand);

		Brand brandFound = brandRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Marca não encontrada."));
		
		BeanUtils.copyProperties(brand, brandFound, "id");
		
		Brand brandSaved = brandRepository.save(brandFound);

		return new BrandResponseDTO(brandSaved);
	}

	public Page<BrandResponseDTO> listBrands(Pageable pageable) {
		Page<Brand> page = brandRepository.findAll(pageable);
		
		return page.map(BrandResponseDTO::new);
	}
}