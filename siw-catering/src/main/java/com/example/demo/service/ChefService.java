package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Chef;
import com.example.demo.repository.ChefRepository;

@Service
public class ChefService {

	@Autowired
	ChefRepository chefRepository;
	
	@Transactional
	public void save(Chef chef) {
		chefRepository.save(chef);
	}
	
	public Chef findById(Long id) {
		return chefRepository.findById(id).get();
	}
	
	@Transactional
	public void delete(Chef chef) {
		chefRepository.delete(chef);
	}
	
	@Transactional
	public void deleteById(Long id) {
		chefRepository.delete(findById(id));
	}
	
	public List<Chef> findByNome(String nome){
		return chefRepository.findByNome(nome);
	}
	
	public List<Chef> findAll(){
		List<Chef> chef = new ArrayList<>();
		for (Chef c : chefRepository.findAll() )
			chef.add(c);
		return chef;
	}
	
	public boolean alreadyExists(Chef chef) {
		return chefRepository.existsByNomeAndCognome(chef.getNome(), chef.getCognome());
	}
}
