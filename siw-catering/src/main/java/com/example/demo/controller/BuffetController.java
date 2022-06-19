package com.example.demo.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Buffet;
import com.example.demo.service.BuffetService;

@Controller
public class BuffetController {
	@Autowired BuffetService buffetService;

	
	@GetMapping("/buffet")
	public String getBuffet(Model model) {
		List<Buffet> buffets = buffetService.findAll();
		model.addAttribute("buffets", buffets);
		return "buffet.html";
	}
	
	@GetMapping("/buffet/{id}/piatti")
	public String getPiattiDiBuffet() {
		return "buffetid.html";
	}
	
	@PostMapping("/buffet")
	public String addBuffet(@Valid @ModelAttribute("buffet") Buffet buffet, Model model,BindingResult bindingResult) {
	    buffetService.save(buffet);
	    model.addAttribute("buffet",buffet);
		return "buffet.html";
	}
	
	
	@GetMapping("/admin/buffet")
	public String getDatiBuffet(Model model){
		model.addAttribute("buffet", new Buffet());
		return "buffetForm.html";
	}
	
	@Transactional
	@GetMapping("/admin/deleteBuffet/{id}")
	public String deleteBuffet(@PathVariable("id") Long id, Model model) {
		buffetService.deleteById(id);
		model.addAttribute("buffet", buffetService.findAll());
		return "buffet.html";
	}
}
