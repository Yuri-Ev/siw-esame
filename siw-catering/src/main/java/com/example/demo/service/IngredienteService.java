package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ingrediente;
import com.example.demo.repository.IngredienteRepository;

@Service
public class IngredienteService {

	@Autowired
	IngredienteRepository ingredienteRepository;
	
	public Ingrediente findById(Long id) {
		return ingredienteRepository.findById(id).get();
	}
	
	
	public List<Ingrediente> findByNome(String nome){
		return ingredienteRepository.findByNome(nome);
	}
	
	public List<Ingrediente> findAll(){
		List<Ingrediente> ingredienti = new ArrayList<>();
		for (Ingrediente i : ingredienteRepository.findAll() )
			ingredienti.add(i);
		return ingredienti;
	}
	
	public boolean alreadyExists(Ingrediente ingrediente) {
		return ingredienteRepository.existsByNomeAndDescrizione(ingrediente.getNome(), ingrediente.getDescrizione());
	}
}
