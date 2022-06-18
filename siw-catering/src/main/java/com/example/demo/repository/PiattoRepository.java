package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Piatto;

public interface PiattoRepository extends CrudRepository<Piatto, String>{
	
	public boolean existsByNomeAndDescrizione(String nome,String descrizione);

}
