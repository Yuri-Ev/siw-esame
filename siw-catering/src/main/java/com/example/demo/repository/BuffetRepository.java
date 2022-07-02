package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Buffet;
import com.example.demo.model.Chef;
import com.example.demo.model.Piatto;

public interface BuffetRepository extends CrudRepository<Buffet, Long>{

	public List<Buffet> findByNome(String nome);
	
	public boolean existsByNomeAndDescrizione(String nome,String descrizione);
	
	public List<Buffet> findByPropositore(Chef chef);
	
	public List<Buffet> findByPiattiProposti(Piatto piatto);
}
