package com.org.auto_mendes_back_end_java.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
	private LocalDateTime localDateTime;
	private Integer status;
	private String message;
	private String path;
}