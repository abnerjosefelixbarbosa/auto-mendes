package com.auto_mendes.backend.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auto_mendes.backend.dto.request.BrandRequestDTO;
import com.auto_mendes.backend.dto.response.BrandResponseDTO;
import com.auto_mendes.backend.service.BrandService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/brands")
@RequiredArgsConstructor
public class BrandController {
	private final BrandService brandService;
	
	@PostMapping(value = "/register-brand")
	public ResponseEntity<BrandResponseDTO> registerBrand(@Valid @RequestBody BrandRequestDTO brandRequestDTO) {
		BrandResponseDTO response = brandService.registerBrand(brandRequestDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping(value = "/update-brand-by-id")
	public ResponseEntity<BrandResponseDTO> updateBrandByid(@RequestParam String id, @Valid @RequestBody BrandRequestDTO brandRequestDTO) {
		BrandResponseDTO response = brandService.updateBrandByid(id, brandRequestDTO);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(value = "/list-brand-by-name")
	public ResponseEntity<Page<BrandResponseDTO>> listBrandByName(@RequestParam String name, Pageable pageable) {
		Page<BrandResponseDTO> page = brandService.listBrandByName(name, pageable);
		
		return ResponseEntity.status(HttpStatus.OK).body(page);
	}
	
	@GetMapping(value = "/list-brand")
	public ResponseEntity<Page<BrandResponseDTO>> listBrand(Pageable pageable) {
		Page<BrandResponseDTO> page = brandService.listBrand(pageable);
		
		return ResponseEntity.status(HttpStatus.OK).body(page);
	}
}