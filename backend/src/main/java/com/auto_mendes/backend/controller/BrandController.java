package com.auto_mendes.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.auto_mendes.backend.dto.BrandRequestDTO;
import com.auto_mendes.backend.dto.BrandResponseDTO;
import com.auto_mendes.backend.service.IBrandService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/brands")
public class BrandController {
	@Autowired
	private IBrandService brandService;

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/register-brand", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BrandResponseDTO> registerBrand(@RequestBody @Valid BrandRequestDTO dto) {
		BrandResponseDTO response = brandService.registerBrand(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@PutMapping(value = "/update-brand-id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BrandResponseDTO> updateBrandById(@RequestParam String id,
			@RequestBody @Valid BrandRequestDTO dto) {
		BrandResponseDTO response = brandService.updateBrandById(id, dto);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/list-brands", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<BrandResponseDTO>> listBrands(Pageable pageable) {
		Page<BrandResponseDTO> page = brandService.listBrands(pageable);

		return ResponseEntity.status(HttpStatus.OK).body(page);
	}
}