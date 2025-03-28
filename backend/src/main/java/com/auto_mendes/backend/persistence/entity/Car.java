package com.auto_mendes.backend.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "car_tb")
@PrimaryKeyJoinColumn(name = "id")
public class Car extends Vehicle {
	private static final long serialVersionUID = 1L;
}