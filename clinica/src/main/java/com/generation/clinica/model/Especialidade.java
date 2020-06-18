package com.generation.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tbEspecialidade")
@Data
public class Especialidade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codEspecialidade;
	
	@Column(name = "nomeEspecialidade", length=50)
	private String nomeEspecialidade;

}
