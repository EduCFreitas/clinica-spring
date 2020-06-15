package com.generation.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.clinica.model.Ficha;

@Repository
public interface FichaRepository extends JpaRepository<Ficha, Long>{

}
