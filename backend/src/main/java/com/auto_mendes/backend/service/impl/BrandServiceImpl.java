package com.auto_mendes.backend.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.request.BrandRequestDTO;
import com.auto_mendes.backend.dto.response.BrandResponseDTO;
import com.auto_mendes.backend.mapper.BrandMapper;
import com.auto_mendes.backend.model.Brand;
import com.auto_mendes.backend.repository.BrandRepository;
import com.auto_mendes.backend.service.BrandService;
import com.auto_mendes.backend.validation.BrandValidation;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
	private final BrandRepository brandRepository;
	private final BrandValidation brandValidation;

	public BrandResponseDTO registerBrand(BrandRequestDTO brandRequestDTO) {
		Brand brand = BrandMapper.toBrand(brandRequestDTO);

		brandValidation.validateBrand(brand);

		Brand brandSaved = brandRepository.save(brand);

		return BrandMapper.toBrandResponseDTO(brandSaved);
	}

	public BrandResponseDTO updateBrandByid(String id, BrandRequestDTO brandRequestDTO) {
		Brand brand = BrandMapper.toBrand(brandRequestDTO);

		brandValidation.validateBrand(brand);

		Brand brandFound = brandRepository.findById(id)
				.orElseThrow(() -> new EntityExistsException("Marca não encontrada."));

		brandFound.update(brand);

		Brand brandSaved = brandRepository.save(brandFound);

		return BrandMapper.toBrandResponseDTO(brandSaved);
	}

	public Page<BrandResponseDTO> listBrandByName(String name, Pageable pageable) {
		return brandRepository.findAllByNameContaining(name, pageable).map(BrandMapper::toBrandResponseDTO);
	}

	public Brand findBrandByName(String name) {
		return brandRepository.findByName(name)
				.orElseThrow(() -> new EntityNotFoundException("Nome da marca não encontrado."));
	}
}