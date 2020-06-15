package com.generation.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.clinica.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	public List<Paciente> findAllByNomeContainingIgnoreCase(String titulo);
}
