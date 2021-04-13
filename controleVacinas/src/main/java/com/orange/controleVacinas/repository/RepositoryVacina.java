package com.orange.controleVacinas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orange.controleVacinas.model.Vacina;

@Repository
public interface RepositoryVacina extends JpaRepository <Vacina, Long> {
	
	public List <Vacina> findAllByNomeVacinaContainingIgnoreCase(String nomeVacina);
}
