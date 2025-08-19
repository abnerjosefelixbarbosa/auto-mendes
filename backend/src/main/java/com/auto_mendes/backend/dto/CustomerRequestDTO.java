package com.auto_mendes.backend.dto;

import org.hibernate.validator.constraints.Length;

import com.auto_mendes.backend.enums.CustomerType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerRequestDTO {
	@NotNull(message = "Documento deve ser obrigatório.")
	@NotEmpty(message = "Documento deve ser obrigatório.")
	@Length(max = 20, message = "Documento deve ter no máximo 20 caracteres.")
	private String document;
	@NotNull(message = "Nome deve ser obrigatório.")
	@NotEmpty(message = "Nome deve ser obrigatório.")
	@Length(max = 100, message = "Nome deve ter no máximo 100 caracteres.")
	private String name;
	@Email(message = "Email deve ser valido.")
	@NotNull(message = "Email deve ser obrigatório.")
	@NotEmpty(message = "Email deve ser obrigatório.")
	@Length(max = 50, message = "Email deve ter no máximo 50 caracteres.")
	private String email;
	@NotNull(message = "Telefone deve ser obrigatório.")
	@NotEmpty(message = "Telefone deve ser obrigatório.")
	@Length(max = 30, message = "Telefone deve ter no máximo 30 caracteres.")
	private String phone;
	@NotNull(message = "Tipo de cliente deve ser obrigatório.")
	private CustomerType customerType;
}