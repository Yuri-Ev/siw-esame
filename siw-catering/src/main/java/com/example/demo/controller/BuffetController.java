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

import com.example.demo.model.Buffet;
import com.example.demo.model.Chef;
import com.example.demo.model.Piatto;
import com.example.demo.service.BuffetService;
import com.example.demo.service.ChefService;
import com.example.demo.service.PiattoService;
import com.example.demo.validator.BuffetValidator;

@Controller
public class BuffetController {
	@Autowired 
	BuffetService buffetService;

	@Autowired
	BuffetValidator validator;

	@Autowired
	PiattoService piattoService;

	@Autowired
	ChefService chefService;


	@GetMapping("/buffets")
	public String getListaBuffets(Model model) {
		List<Buffet> buffets = buffetService.findAll();
		model.addAttribute("buffets", buffets);
		return "buffets.html";
	}
	
	@GetMapping("/buffetsAdmin")
	public String getListaBuffetsAdmin(Model model) {
		List<Buffet> buffets = buffetService.findAll();
		model.addAttribute("buffets", buffets);
		return "buffetsAdmin.html";
	}


	@PostMapping("/buffetAdmin")
	public String addBuffet(@Valid @ModelAttribute("buffet") Buffet buffet,BindingResult bindingResult, Model model) {
		validator.validate(buffet, bindingResult);
		if (!bindingResult.hasErrors()) {
			buffetService.save(buffet);
			model.addAttribute("buffet",buffet);
			return "buffetAdmin.html";
		}
		model.addAttribute("piatti",piattoService.findAll());
		model.addAttribute("chefs",chefService.findAll());
		return "buffetForm.html";
	}

	@GetMapping("/buffet/{id}")
	public String getBuffet(@PathVariable("id") Long id, Model model) {
		Buffet buffet = buffetService.findById(id);
		model.addAttribute("buffet",buffet);
		return "buffet.html";
	}
	
	@GetMapping("/buffetAdmin/{id}")
	public String getBuffetAdmin(@PathVariable("id") Long id, Model model) {
		Buffet buffet = buffetService.findById(id);
		model.addAttribute("buffet",buffet);
		return "buffetAdmin.html";
	}

	@GetMapping("/admin/buffet")
	public String getFormBuffet(Model model){
		model.addAttribute("buffet", new Buffet());
		List<Piatto> piatti = piattoService.findAll();
		model.addAttribute("piatti",piatti);
		List<Chef> chefs = chefService.findAll();
		model.addAttribute("chefs",chefs);
		return "buffetForm.html";
	}


	@GetMapping("/admin/toDeleteBuffet/{id}")
	public String toDeleteBuffet(@PathVariable("id") Long id, Model model) {
		model.addAttribute("buffet",buffetService.findById(id));
		return "riepilogoToDeleteBuffet.html";
	}


	@GetMapping("/admin/deleteBuffet/{id}")
	public String deleteBuffet(@PathVariable("id") Long id, Model model) {
		buffetService.deleteById(id);
		model.addAttribute("buffets", buffetService.findAll());
		return "buffetsAdmin.html";
	}


	@GetMapping("/admin/editBuffet/{id}")
	public String toEditBuffet(@PathVariable("id") Long id, Model model) {
		Buffet buffet = buffetService.findById(id);
		model.addAttribute("buffet",buffet);
		model.addAttribute("vecchioNomeBuffet",buffet.getNome());
		List<Piatto> piatti = piattoService.findAll();
		model.addAttribute("piatti",piatti);
		List<Chef> chefs = chefService.findAll();
		model.addAttribute("chefs",chefs);
		return "buffetEditForm.html";
	}

	@PostMapping("/admin/buffet/edit/{id}")
	public String editBuffet(@Valid @ModelAttribute("buffet") Buffet buffet,BindingResult bindingResult, Model model) {
		validator.validate(buffet, bindingResult);
		if (!bindingResult.hasErrors()) {
			buffetService.save(buffet);
			model.addAttribute("buffet",buffet);
			return "buffetAdmin.html";
		}
		model.addAttribute("piatti",piattoService.findAll());
		model.addAttribute("chefs",chefService.findAll());
		return "buffetEditForm.html";
	}

}
