package com.org.auto_mendes_back_end_spring_boot_java.dtos.responses;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkResponseDTO {
	private String id;
	private String name;
	
	public MarkResponseDTO(Mark mark) {
		this.id = mark.getId();
		this.name = mark.getName();
	}
}