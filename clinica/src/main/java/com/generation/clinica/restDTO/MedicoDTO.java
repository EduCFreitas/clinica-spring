package com.generation.clinica.restDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicoDTO {
	private Long crm;
	
	private String nome;
	
	private Long codEspecialidade;
	
}
