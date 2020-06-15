package com.generation.clinica.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbMedico")
public class Medico {
	@Id
	private String crm;
	
	@Column(name="nome", nullable=false)
	@Size(min=2, max=80)
	private String nome;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codEspecialidade", referencedColumnName="codEspecialidade")
	private Especialidade especialidade;

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
	
}
