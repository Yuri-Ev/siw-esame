package com.example.demo.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Ingrediente;
import com.example.demo.model.Piatto;

public interface PiattoRepository extends CrudRepository<Piatto, String>{
	
	public boolean existsByNomeAndDescrizioneAndIngredienti(String nome,String descrizione,List<Ingrediente> ingredienti);

}
