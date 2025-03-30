package com.auto_mendes.backend.model.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record ExceptionResponseDTO(
		@JsonFormat(pattern = "yyyy-MM-dd HH:ss")
		LocalDateTime localDateTime,
		Integer status,
		String message,
		String path
) {}