package com.auto_mendes.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto_mendes.backend.model.dto.request.BrandRequestDTO;
import com.auto_mendes.backend.model.dto.response.BrandResponseDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/brands")
public class BrandController {

	
	@PostMapping(value = "/register-brand")
	public ResponseEntity<BrandResponseDTO> registerBrand(@Valid @RequestBody BrandRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
}