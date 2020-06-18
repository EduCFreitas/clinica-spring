package com.generation.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "tbMedico")
@Data
public class Medico {
	@Id
	private Long crm;
	
	@Column(name="nome", nullable=false)
	@Size(min=2, max=80)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="codEspecialidade")
	private Especialidade especialidade;

}
