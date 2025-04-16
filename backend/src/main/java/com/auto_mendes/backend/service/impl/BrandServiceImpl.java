package com.auto_mendes.backend.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.BrandRequestDTO;
import com.auto_mendes.backend.dto.BrandResponseDTO;
import com.auto_mendes.backend.entity.Brand;
import com.auto_mendes.backend.mapper.BrandMapper;
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
	private final BrandMapper brandMapper;
	private final BrandValidation brandValidation;
	
	public BrandResponseDTO registerBrand(BrandRequestDTO dto) {
		Brand brand = brandMapper.toBrand(dto);
		
		brandValidation.validateBrand(brand);
		
		Brand brandSaved = brandRepository.save(brand);
		
		return brandMapper.toBrandResponseDTO(brandSaved);
	}

	public BrandResponseDTO updateBrandByid(String id, BrandRequestDTO dto) {
        Brand brand = brandMapper.toBrand(dto);
		
		brandValidation.validateBrand(brand);
		
		Brand brandFound = brandRepository.findById(id)
				.orElseThrow(() -> new EntityExistsException("Marca não encontrada."));
		
		brandFound.update(brand);
		
		Brand brandSaved = brandRepository.save(brandFound);
		
		return brandMapper.toBrandResponseDTO(brandSaved);
	}

	public Page<BrandResponseDTO> listBrandByName(String name, Pageable pageable) {
		return brandRepository.findAllByNameContaining(name, pageable)
				.map(brandMapper::toBrandResponseDTO);
	}
	
	public Brand findBrandByName(String name) {
		return brandRepository.findByName(name)
				.orElseThrow(() -> new EntityNotFoundException("Nome da marca não encontrado."));
	}
}