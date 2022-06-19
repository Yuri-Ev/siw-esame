package com.example.demo.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@PostMapping("/admin/piatto")
	public String addPiatto(@PathVariable("id") String id, Model model) {
	    model.addAttribute("piatto", this.piattoService.searchById(id));
		return "piatto.html";
	}
	
	@Transactional
	@GetMapping("/admin/deletePiatto/{id}")
	public String deletePiatto(@PathVariable("id") String id, Model model) {
		piattoService.deleteById(id);
		model.addAttribute("piatto", piattoService.findAll());
		return "piatto.html";
	}
}
