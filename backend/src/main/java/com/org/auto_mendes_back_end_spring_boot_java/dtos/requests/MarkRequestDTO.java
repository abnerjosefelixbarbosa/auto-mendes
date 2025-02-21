package com.org.auto_mendes_back_end_spring_boot_java.dtos.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkRequestDTO {
	@NotEmpty(message =  "Nome deve ser obrigatório")
	@NotNull(message = "Nome deve ser obrigatório")
	@Size(message = "Nome deve ter 30 até caracteres", max = 30)
	private String name;
}