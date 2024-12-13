package com.org.auto_mendes_back_end_java.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "models")
public class Model implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	private Brand brand;
}
