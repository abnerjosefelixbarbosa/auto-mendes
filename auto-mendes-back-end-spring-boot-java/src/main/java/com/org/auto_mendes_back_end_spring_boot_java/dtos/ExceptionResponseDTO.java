package com.org.auto_mendes_back_end_spring_boot_java.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record ExceptionResponseDTO(
		@JsonFormat(pattern = "yyyy-MM-dd HH:ss")
		LocalDateTime localDateTime,
		Integer status,
		String message,
		String path
) {}