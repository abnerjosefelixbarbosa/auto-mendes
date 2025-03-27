package com.auto_mendes.backend.entity;

import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "assistant_manager_tb")
@PrimaryKeyJoinColumn(name = "id")
public class AssistantManager extends Employee {
	private static final long serialVersionUID = 1L;

	public AssistantManager(EmployeeRequestDTO request) {
		super(null, request.name(), request.email(), request.registration(), request.phone(), request.birthDate());
	}
}