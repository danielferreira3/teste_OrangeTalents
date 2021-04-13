package com.orange.controleVacinas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orange.controleVacinas.model.Vacina;
import com.orange.controleVacinas.repository.RepositoryVacina;


@Service
public class VacinaService {
	
	@Autowired
	private RepositoryVacina repositoryVacina;
	
	public Vacina salvarVacina(Vacina vacina) {
		return repositoryVacina.save(vacina);
	}
}
