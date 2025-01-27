package com.org.auto_mendes_back_end_spring_boot_java.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
	private LocalDateTime localDateTime;
	private Integer status;
	private String message;
	private String path;
}