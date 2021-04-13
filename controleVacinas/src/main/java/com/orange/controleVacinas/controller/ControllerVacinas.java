package com.orange.controleVacinas.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.orange.controleVacinas.model.Vacina;
import com.orange.controleVacinas.repository.RepositoryVacina;
import com.orange.controleVacinas.service.VacinaService;


@RestController
@RequestMapping("/vacina")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ControllerVacinas {
		
			@Autowired
			private VacinaService vacinaService;
			@Autowired
			private RepositoryVacina repository;
			
			@PostMapping("/cadastrar")
			public ResponseEntity<Vacina>Post(@Valid @RequestBody Vacina vacina){
				return ResponseEntity.status(HttpStatus.CREATED)
						.body(vacinaService.salvarVacina(vacina));
			}
			
			
			@GetMapping
			public ResponseEntity <List <Vacina>> GetAll(){
				return ResponseEntity.ok (repository.findAll());
			}
			
			
			@GetMapping("/{id}")
			public ResponseEntity <Vacina> GetById (@PathVariable Long id){
				return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
						
			}
			
			@PutMapping
			public ResponseEntity<Vacina> put(@RequestBody Vacina vacinas){
				return ResponseEntity.ok(repository.save(vacinas));
			}
			
			@DeleteMapping("/{id}")
			public void delete (@PathVariable Long id) {
				repository.deleteById(id);
			}
}
