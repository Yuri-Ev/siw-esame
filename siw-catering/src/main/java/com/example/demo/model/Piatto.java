package com.example.demo.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Piatto {
	
	@Id
	@NotBlank
	private String nome;
	
	@Column(length = 100)
	private String descrizione;

	@OneToMany
	private List<Ingrediente> ingredienti;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
