package com.generation.clinica.controller;

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

import com.generation.clinica.model.Ficha;
import com.generation.clinica.repository.FichaRepository;

@RestController
@RequestMapping("/ficha")
@CrossOrigin("*")
public class FichaController {
	@Autowired
	private FichaRepository repository;
	
	@GetMapping("/{codFicha}")
	public ResponseEntity<Ficha> GetById(@PathVariable long codFicha){
		return repository.findById(codFicha)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Ficha> post(@RequestBody Ficha ficha){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(ficha));
	}
	
	@PutMapping
	public ResponseEntity<Ficha> put (@RequestBody Ficha ficha) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(ficha));
	}
	
	@DeleteMapping("/{codFicha}")
	public void delete(@PathVariable long codFicha) {
		repository.deleteById(codFicha);
	}

}
