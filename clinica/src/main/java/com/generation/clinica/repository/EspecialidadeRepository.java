package com.generation.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.clinica.model.Especialidade;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long>{
	public List<Especialidade> findAllByNomeEspecialidadeContainingIgnoreCase(String titulo);
}
