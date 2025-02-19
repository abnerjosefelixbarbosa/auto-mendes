package com.org.auto_mendes_back_end_spring_boot_java.entities;

import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@Table(name = "managers")
@PrimaryKeyJoinColumn(name = "id")
public class Manager extends Employee {
	private static final long serialVersionUID = 1L;

	public Manager(EmployeeRequestDTO request) {
		super(UlidCreator.getUlid().toString(), request.getName(), request.getCpf(), request.getEmail(),
				request.getTelephone(), request.getSalary(), request.getMatriculation());
	}
}