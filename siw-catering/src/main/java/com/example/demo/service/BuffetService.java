package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Buffet;
import com.example.demo.repository.BuffetRepository;

@Service
public class BuffetService {

	@Autowired
	private BuffetRepository buffetRepository;
	
	@Transactional
	public Buffet save(Buffet buffet) {
		return buffetRepository.save(buffet);
	}
	
	public List<Buffet> searchByNome(String nome){
		return buffetRepository.findByNome(nome);
	}
	
	public Buffet searchById(Long id){
		return buffetRepository.findById(id).get();
	}
	
	@Transactional
	public void delete(Buffet buffet) {
		buffetRepository.delete(buffet);
	}
	
	@Transactional
	public void deleteById(Long id) {
		buffetRepository.delete(searchById(id));
	}
	
	public List<Buffet> findAll(){
		List<Buffet> buffet = new ArrayList<>();
		for (Buffet b : buffetRepository.findAll() )
			buffet.add(b);
		return buffet;
	}
	
	public boolean alreadyExists(Buffet buffet) {
		return buffetRepository.existsByNomeAndDescrizioneAndPropositoreAndPiattiProposti(buffet.getNome(),buffet.getDescrizione(),buffet.getPropositore(),buffet.getPiattiProposti());
	}
	
}
