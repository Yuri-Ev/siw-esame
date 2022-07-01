package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Piatto;
import com.example.demo.repository.PiattoRepository;

@Service
public class PiattoService {

	@Autowired
	private PiattoRepository piattoRepository;
	
	@Transactional
	public Piatto save(Piatto piatto) {
		return piattoRepository.save(piatto);
	}
	
	public Piatto findById(Long id){
		return piattoRepository.findById(id).get();
	}
	
	@Transactional
	public void delete(Piatto piatto) {
		piattoRepository.delete(piatto);
	}
	
	@Transactional
	public void deleteById(Long id) {
		piattoRepository.delete(findById(id));
	}
	
	public List<Piatto> findAll(){
		List<Piatto> piatti = new ArrayList<>();
		for (Piatto p : piattoRepository.findAll() )
			piatti.add(p);
		return piatti;
	}
	
	public boolean alreadyExists(Piatto piatto) {
		return piattoRepository.existsByNome(piatto.getNome());
	}
}
