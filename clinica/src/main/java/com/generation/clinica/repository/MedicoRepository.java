package com.generation.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.clinica.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, String>{
	public List<Medico> findAllByNomeContainingIgnoreCase(String titulo);
}
