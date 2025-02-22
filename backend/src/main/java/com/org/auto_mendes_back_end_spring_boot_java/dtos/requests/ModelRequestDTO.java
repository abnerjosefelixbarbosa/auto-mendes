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
public class ModelRequestDTO {
	@NotNull(message = "Nome deve ser obrigatório")
	@NotEmpty(message = "Nome deve ser obrigatório")
	@Size(message = "Nome deve ter até 30 caracteres", max = 30)
	private String name;
	@NotNull(message = "Nome da marca deve ser obrigatório")
	@NotEmpty(message = "Nome da marca deve ser obrigatório")
	@Size(message = "Nome da marca deve ter até 30 caracteres", max = 30)
	private String markName;
}
