package com.org.auto_mendes_back_end_spring_boot_java.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "cars")
@PrimaryKeyJoinColumn(name = "id")
public class Car extends Vehicle {
	private static final long serialVersionUID = 1L;
}