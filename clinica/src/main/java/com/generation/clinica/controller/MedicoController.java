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
import org.springframework.web.server.ResponseStatusException;

import com.generation.clinica.model.Especialidade;
import com.generation.clinica.model.Medico;
import com.generation.clinica.repository.EspecialidadeRepository;
import com.generation.clinica.repository.MedicoRepository;
import com.generation.clinica.restDTO.MedicoDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/medico")
@CrossOrigin("*")
@RequiredArgsConstructor
public class MedicoController {
//	@Autowired
//	private MedicoRepository repository;
	
	private final EspecialidadeRepository especialidadeRepository;
	private final MedicoRepository repository;
	
	
	@GetMapping("/{crm}")
	public ResponseEntity<Medico> GetById(@PathVariable String crm){
		return repository.findById(crm)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity<List<Medico>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Medico>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
//	@PostMapping
//	public ResponseEntity<Medico> post(@RequestBody Medico medico){
//		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(medico));
//	}
	
	@PostMapping
	public Medico salvar (@RequestBody MedicoDTO dto) {
		Long codEspecialidade = dto.getCodEspecialidade();
		
		Especialidade especialidade = especialidadeRepository.findById(codEspecialidade)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Especialidade inexistente."));
		
		Medico medico = new Medico();
		medico.setEspecialidade(especialidade);
		medico.setCrm(dto.getCrm());
		medico.setNome(dto.getNome());
		
		return repository.save(medico);
	}
	
	@PutMapping
	public ResponseEntity<Medico> put (@RequestBody Medico medico) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(medico));
	}
	
	@DeleteMapping("/{crm}")
	public void delete(@PathVariable String crm) {
		repository.deleteById(crm);
	}
}
