package com.org.auto_mendes_back_end_spring_boot_java.dtos.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarkRequestDTO {
	@NotEmpty(message =  "Nome não deve ser vazio")
	@NotNull(message = "Nome não deve ser nulo")
	@Size(message = "Nome deve ter 30 caracteres", max = 30)
	private String name;
}