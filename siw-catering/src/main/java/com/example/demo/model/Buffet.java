package com.example.demo.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Buffet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(length = 100)
	private String descrizione;

	@ManyToOne
	private Chef propositore;
	
	@OneToMany
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
