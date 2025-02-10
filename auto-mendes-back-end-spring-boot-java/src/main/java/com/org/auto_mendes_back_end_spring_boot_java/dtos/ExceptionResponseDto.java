package com.org.auto_mendes_back_end_spring_boot_java.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseDto {
	@JsonFormat(pattern = "yyyy-MM-dd HH:ss")
	private LocalDateTime localDateTime;
	private Integer status;
	private String message;
	private String path;
}