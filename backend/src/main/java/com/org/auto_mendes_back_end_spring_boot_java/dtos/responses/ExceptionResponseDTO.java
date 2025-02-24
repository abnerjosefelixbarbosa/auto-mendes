package com.org.auto_mendes_back_end_spring_boot_java.dtos.responses;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "DTO de resposta da exceção")
@Data
public class ExceptionResponseDTO {
	@Schema(description = "Data e hora da exceção")
	@JsonFormat(pattern = "yyyy-MM-dd HH:ss")
	private LocalDateTime localDateTime;
	@Schema(description = "Status da exceção")
	private Integer status;
	@Schema(description = "Mensagem da exceção")
	private String message;
	@Schema(description = "Caminho da exceção")
	private String path;
}