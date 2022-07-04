package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Chef {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Size(max = 20)
	@NotBlank
	private String nome;
	
	@Size(max = 30)
	@NotBlank
	private String cognome;
	
	@NotBlank
	private String nazionalita;

	
	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

}
