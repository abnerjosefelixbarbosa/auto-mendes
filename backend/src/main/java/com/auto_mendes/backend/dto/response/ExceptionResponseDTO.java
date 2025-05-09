package com.auto_mendes.backend.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponseDTO {
	@JsonFormat(pattern = "yyyy-MM-dd HH:ss")
	private LocalDateTime localDateTime;
	private Integer status;
	private String message;
	private String path;
}