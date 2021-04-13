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

import com.orange.controleVacinas.model.Usuario;
import com.orange.controleVacinas.repository.RepositoryUsuario;
import com.orange.controleVacinas.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ControllerUsuarios {
	
		
		@Autowired
		private UsuarioService usuarioService;
		@Autowired
		private RepositoryUsuario repository;
		
		@PostMapping("/cadastrar")
		public ResponseEntity<Usuario>Post(@Valid @RequestBody Usuario usuarios){
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(usuarioService.salvarUsuario(usuarios));
		}
		
		
		@GetMapping
		public ResponseEntity <List <Usuario>> GetAll(){
			return ResponseEntity.ok (repository.findAll());
		}
		
		
		@GetMapping("/{id}")
		public ResponseEntity <Usuario> GetById (@PathVariable Long id){
			return repository.findById(id)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());
					
		}
		
		@PutMapping
		public ResponseEntity<Usuario> put(@RequestBody Usuario usuarios){
			return ResponseEntity.ok(repository.save(usuarios));
		}
		
		@DeleteMapping("/{id}")
		public void delete (@PathVariable Long id) {
			repository.deleteById(id);
		}
}
