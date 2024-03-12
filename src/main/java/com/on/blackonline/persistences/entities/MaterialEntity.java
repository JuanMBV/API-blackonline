package com.on.blackonline.persistences.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "materials")
public class MaterialEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long material_id;

	@Column(name = "price")
	private int price;

	// Falta la relación muchos a muchos con la tabla de tecnicas
}
