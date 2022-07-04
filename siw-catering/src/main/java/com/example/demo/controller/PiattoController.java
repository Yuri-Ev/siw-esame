package com.example.demo.controller;

import java.util.List;

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
import com.example.demo.service.BuffetService;
import com.example.demo.service.IngredienteService;
import com.example.demo.service.PiattoService;
import com.example.demo.validator.PiattoValidator;

@Controller
public class PiattoController {

	@Autowired 
	PiattoService piattoService;

	@Autowired
	IngredienteService ingredienteService;

	@Autowired
	BuffetService buffetService;
	
	@Autowired
	PiattoValidator validator;


	@GetMapping("/piatti")
	public String getListaPiatti (Model model) {
		List<Piatto> piatti = piattoService.findAll();
		model.addAttribute("piatti", piatti);
		return "piatti.html";
	}


	@PostMapping("/piatto")
	public String addPiatto(@Valid @ModelAttribute("piatto") Piatto piatto,BindingResult bindingResult, Model model) {
		validator.validate(piatto, bindingResult);
		if (!bindingResult.hasErrors()) {
			piattoService.save(piatto);
			model.addAttribute("piatto",piatto);
			return "piatto.html";
		}
		model.addAttribute("listaIngredienti",ingredienteService.findAll());
		return "piattoForm.html";
	}


	@GetMapping("/piatto/{id}")
	public String getPiatto(@PathVariable("id") Long id,Model model){
		Piatto piatto = piattoService.findById(id);
		model.addAttribute("piatto", piatto);
		model.addAttribute("buffetsConPiatto",buffetService.findByPiatto(piatto));
		return "piatto.html";
	}


	@GetMapping("/admin/piatto")
	public String getFormPiatto(Model model){
		model.addAttribute("piatto", new Piatto());
		model.addAttribute("listaIngredienti",ingredienteService.findAll());
		return "piattoForm.html";
	}



	@GetMapping("/admin/toDeletePiatto/{id}")
	public String toDeletePiatto(@PathVariable("id") Long id, Model model) {
		model.addAttribute("piatto",piattoService.findById(id));
		return "riepilogoToDeletePiatto.html";
	}



	@GetMapping("/admin/deletePiatto/{id}")
	public String deletePiatto(@PathVariable("id") Long id, Model model) {
		piattoService.deleteById(id);
		model.addAttribute("piatti", piattoService.findAll());
		return "piatti.html";
	}
}
