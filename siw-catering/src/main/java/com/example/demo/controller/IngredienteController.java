package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Ingrediente;
import com.example.demo.service.IngredienteService;

@Controller
public class IngredienteController {
	
	@Autowired
	IngredienteService ingredienteService;

	@GetMapping("/ingrediente/{id}")
	public String getDatiIngrediente(@PathVariable("id") Long id, Model model) {
		Ingrediente ingrediente = ingredienteService.findById(id);
		model.addAttribute("ingrediente",ingrediente);
		return "ingrediente.html";
	}
	
	@GetMapping("/ingredienteAdmin/{id}")
	public String getDatiIngredienteAdmin(@PathVariable("id") Long id, Model model) {
		Ingrediente ingrediente = ingredienteService.findById(id);
		model.addAttribute("ingrediente",ingrediente);
		return "ingredienteAdmin.html";
	}
}
