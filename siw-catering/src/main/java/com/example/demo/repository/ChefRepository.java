package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Chef;

public interface ChefRepository extends CrudRepository<Chef, Long>{
	
	public List<Chef> findByNome(String nome);
	
	public List<Chef> findByNomeOrCognome(String nome,String cognome);
	
	public boolean existsByNomeAndCognome(String nome,String cognome);
}
