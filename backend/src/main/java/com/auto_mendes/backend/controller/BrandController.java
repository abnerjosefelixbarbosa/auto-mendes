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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/brands")
public class BrandController {
	@Autowired
	private IBrandService brandService;

	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Cria uma marca."),
			@ApiResponse(responseCode = "400", description = "Retorna um erro na requesição.") })
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(summary = "Registra marca.", description = "Registra uma marca.")
	@PostMapping(value = "/register-brand", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BrandResponseDTO> registerBrand(@RequestBody @Valid BrandRequestDTO dto) {
		BrandResponseDTO response = brandService.registerBrand(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Atualiza uma marca."),
			@ApiResponse(responseCode = "400", description = "Retorna um erro na requesição."),
			@ApiResponse(responseCode = "404", description = "Retorna marca não encontrada.") })
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Atualiza marca.", description = "Atualiza uma marca.")
	@PutMapping(value = "/update-brand-id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BrandResponseDTO> updateBrandById(@RequestParam String id,
			@RequestBody @Valid BrandRequestDTO dto) {
		BrandResponseDTO response = brandService.updateBrandById(id, dto);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Lista todas as marcas.") })
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Lista marcas.", description = "Lista todas marcas.")
	@GetMapping(value = "/list-brands", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<BrandResponseDTO>> listBrands(Pageable pageable) {
		Page<BrandResponseDTO> page = brandService.listBrands(pageable);

		return ResponseEntity.status(HttpStatus.OK).body(page);
	}
}