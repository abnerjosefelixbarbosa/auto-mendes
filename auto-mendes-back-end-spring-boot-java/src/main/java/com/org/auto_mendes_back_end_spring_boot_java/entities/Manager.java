package com.org.auto_mendes_back_end_spring_boot_java.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "2")
public class Manager extends Employee {
	private static final long serialVersionUID = 1L;
}
