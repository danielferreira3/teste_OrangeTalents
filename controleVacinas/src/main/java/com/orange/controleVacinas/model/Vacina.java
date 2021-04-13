package com.orange.controleVacinas.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tb_vacinas")
public class Vacina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull @NotEmpty
	@Column(name = "nomeVacina")
	private String nomeVacina;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataRealizada;

	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNomeVacina() {
		return nomeVacina;
	}


	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public LocalDate getDataRealizada() {
		return dataRealizada;
	}


	public void setDataRealizada(LocalDate dataRealizada) {
		this.dataRealizada = dataRealizada;
	}
	
	
	
}
