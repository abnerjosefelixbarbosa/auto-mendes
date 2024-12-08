package com.org.auto_mendes_back_end_java.dto;

import java.time.LocalDateTime;

public record ExceptionResponse(
		LocalDateTime localDateTime,
		Integer status,
		String message,
		String path
) {}