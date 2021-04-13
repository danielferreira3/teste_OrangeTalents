package com.orange.controleVacinas.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orange.controleVacinas.model.Usuario;
import com.orange.controleVacinas.repository.RepositoryUsuario;

@Service
public class UsuarioService {
	
	@Autowired
	private RepositoryUsuario repositoryUsuario;
	
	public Usuario salvarUsuario(Usuario usuarios) {
		return repositoryUsuario.save(usuarios);
	}
	

	
}
