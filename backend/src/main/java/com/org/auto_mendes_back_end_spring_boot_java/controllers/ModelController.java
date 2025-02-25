package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.ModelRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.ExceptionResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.ModelResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.services.IModelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/models")
@Tag(name = "Modelos", description = "Operações relacionadas aos modelos")
public class ModelController {
	@Autowired
	private IModelService modelService;
	
	@Operation(summary = "Registrar modelo", description = "Registra um modelo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Cria um modelo", content = @Content(schema = @Schema(implementation = ModelResponseDTO.class))),
			@ApiResponse(responseCode = "400", description = "Retorna um erro de requesição", content = @Content(schema = @Schema(implementation = ExceptionResponseDTO.class))), })
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/register-model")
	public ResponseEntity<ModelResponseDTO> registerModel(@Valid @RequestBody ModelRequestDTO dto) {
		ModelResponseDTO modelResponseDTO = modelService.registerModel(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(modelResponseDTO);
	}
}
