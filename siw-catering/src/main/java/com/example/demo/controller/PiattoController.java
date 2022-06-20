package com.example.demo.controller;

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

import com.example.demo.model.Piatto;
import com.example.demo.service.PiattoService;

@Controller
public class PiattoController {
	
	@Autowired PiattoService piattoService;

	@GetMapping("/piatto")
	public String getPiatti () {
		return "piatto.html";
	}
	
	@GetMapping("/piatto/{nome}/ingredienti")
	public String getIngredientiDiPiatto () {
		return "piattoid.html";
	}
	
	@GetMapping("/ingredienti")
	public String getIngredienti() {
		return "ingredienti.html";
	}
	
	@GetMapping("/ingrediente/{cod}")
	public String getIngrediente() {
		return "ingredientecod.html";
	}
	
	
	@Transactional
	@GetMapping("/admin/deletePiatto/{id}")
	public String deletePiatto(@PathVariable("id") String id, Model model) {
		piattoService.deleteById(id);
		model.addAttribute("piatto", piattoService.findAll());
		return "piatto.html";
	}
	
	@GetMapping("/admin/piatto")
	public String getFormPiatto(Model model){
		model.addAttribute("piatto", new Piatto());
		return "piattoForm.html";
	}
	
	@PostMapping("/piatto")
	public String addPiatto(@Valid @ModelAttribute("piatto") Piatto piatto, Model model,BindingResult bindingResult) {
		piattoService.save(piatto);
		model.addAttribute("piatto",piatto);
		return "piatto.html";
	}
	
}
