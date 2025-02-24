package com.org.auto_mendes_back_end_spring_boot_java.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelResponseDTO {
	private String id;
	private String name;
	private String markName;
}
