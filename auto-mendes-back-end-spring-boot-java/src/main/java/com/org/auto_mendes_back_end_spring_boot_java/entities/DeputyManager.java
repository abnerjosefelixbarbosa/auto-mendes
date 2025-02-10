package com.org.auto_mendes_back_end_spring_boot_java.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@DiscriminatorValue(value = "1")
public class DeputyManager extends Employee {
	private static final long serialVersionUID = 1L;
}