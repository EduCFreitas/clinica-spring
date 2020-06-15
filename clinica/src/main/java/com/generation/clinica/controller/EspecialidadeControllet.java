package com.generation.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.clinica.model.Especialidade;
import com.generation.clinica.repository.EspecialidadeRepository;

@RestController
@RequestMapping("/especialidade")
@CrossOrigin("*")
public class EspecialidadeControllet {
	@Autowired
	private EspecialidadeRepository repository;
	
	//get
	@GetMapping("/{codEspecialidade}")
	public ResponseEntity<Especialidade> GetById(@PathVariable long codEspecialidade){
		return repository.findById(codEspecialidade)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity<List<Especialidade>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/nomeEspecialidade/{nomeEspecialidade}")
	public ResponseEntity<List<Especialidade>> GetByNome(@PathVariable String nomeEspecialidade){
		return ResponseEntity.ok(repository.findAllByNomeEspecialidadeContainingIgnoreCase(nomeEspecialidade));
	}
	
	//post
	@PostMapping
	public ResponseEntity<Especialidade> post(@RequestBody Especialidade especialidade){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(especialidade));
	}
	
	//put
	@PutMapping
	public ResponseEntity<Especialidade> put (@RequestBody Especialidade especialidade) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(especialidade));
	}
	
	//delete
	@DeleteMapping("/{codEspecialidade}")
	public void delete(@PathVariable long codEspecialidade) {
		repository.deleteById(codEspecialidade);
	}
}
