package com.auto_mendes.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "pj_tb")
@PrimaryKeyJoinColumn(name = "id")
public class PJ extends Customer {
	private static final long serialVersionUID = 1L;
}