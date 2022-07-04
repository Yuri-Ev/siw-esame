package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Buffet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@NotBlank
	private String nome;
	
	@Size(max = 100)
	private String descrizione;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Chef propositore;
	
	@NotNull
	@ManyToMany
	private List<Piatto> piattiProposti;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Chef getPropositore() {
		return propositore;
	}

	public void setPropositore(Chef propositore) {
		this.propositore = propositore;
	}

	public List<Piatto> getPiattiProposti() {
		return piattiProposti;
	}

	public void setPiattiProposti(List<Piatto> piattiProposti) {
		this.piattiProposti = piattiProposti;
	}

}
