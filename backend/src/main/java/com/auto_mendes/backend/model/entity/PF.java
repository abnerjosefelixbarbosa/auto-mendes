package com.auto_mendes.backend.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "pf_tb")
@PrimaryKeyJoinColumn(name = "id")
public class PF extends Customer {
	private static final long serialVersionUID = 1L;
}