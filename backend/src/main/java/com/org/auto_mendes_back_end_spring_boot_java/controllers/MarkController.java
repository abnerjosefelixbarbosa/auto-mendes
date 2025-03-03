package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.MarkRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.ExceptionResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.MarkResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IMarkService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/marks")
@Tag(name = "Marcas", description = "Operações relacionadas ás marcas")
public class MarkController {
	@Autowired
	private IMarkService markService;
	
	@Operation(summary = "Registrar marca", description = "Registra uma marca")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Cria uma marca", content = @Content(schema = @Schema(implementation = MarkResponseDTO.class))),
			@ApiResponse(responseCode = "400", description = "Retorna um erro de requesição", content = @Content(schema = @Schema(implementation = ExceptionResponseDTO.class))), })
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/register-mark")
	public ResponseEntity<MarkResponseDTO> registerMark(@Valid @RequestBody MarkRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(markService.registerMark(dto));
	}
	
	@PutMapping(value = "/update-mark-by-id")
	public ResponseEntity<MarkResponseDTO> updateMarkById(@RequestParam String id, @Valid @RequestBody MarkRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(markService.updateMark(id, dto));
	}
}
