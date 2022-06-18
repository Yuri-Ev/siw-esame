package com.example.demo.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Piatto {
	
	@Id
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

	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

}
