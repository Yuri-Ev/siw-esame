package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Chef {
	
	@Id
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	private String nazionalitá;

	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNazionalitá() {
		return nazionalitá;
	}

	public void setNazionalitá(String nazionalitá) {
		this.nazionalitá = nazionalitá;
	}

}
