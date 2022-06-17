package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Ingrediente {
	
	@Id
	private String codice;
	
	@Column(nullable = false)
	private String nome;
	
	private String origine;
	
	@Column(length = 100)
	private String descrizione;


	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

}
