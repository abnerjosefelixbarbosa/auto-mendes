package com.org.auto_mendes_back_end_spring_boot_java.dtos.responses;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Model;

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
	
	public ModelResponseDTO(Model model) {
		this.id = model.getId();
		this.name = model.getName();
		this.markName = model.getMark().getName();
	}
}
