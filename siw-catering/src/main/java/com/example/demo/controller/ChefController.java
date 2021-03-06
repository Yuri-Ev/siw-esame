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

import com.example.demo.model.Chef;
import com.example.demo.service.ChefService;
import com.example.demo.validator.ChefValidator;

@Controller
public class ChefController {
	@Autowired 
	ChefService chefService;

	@Autowired
	ChefValidator validator;



	@GetMapping("/chefs")
	public String getListaChefs (Model model) {
		List<Chef> chefs = chefService.findAll();
		model.addAttribute("chefs",chefs);
		return "chefs.html";
	}
	
	@GetMapping("/chefsAdmin")
	public String getListaChefsAdmin (Model model) {
		List<Chef> chefs = chefService.findAll();
		model.addAttribute("chefs",chefs);
		return "chefsAdmin.html";
	}

	@PostMapping("/chefAdmin")
	public String addChef(@Valid @ModelAttribute("chef") Chef chef,BindingResult bindingResult, Model model) {
		validator.validate(chef, bindingResult);
		if(!bindingResult.hasErrors()) {
			chefService.save(chef);
			model.addAttribute("chef",chef);
			return "chefAdmin.html";
		}
		return "chefForm.html";
	}


	@GetMapping("/chef/{id}")
	public String getChef(@PathVariable("id") Long id, Model model) {
		Chef chef = chefService.findById(id);
		model.addAttribute("chef",chef);
		model.addAttribute("buffetsProposti",chef.getBuffetProposti());
		return "chef.html";
	}
	
	@GetMapping("/chefAdmin/{id}")
	public String getChefAdmin(@PathVariable("id") Long id, Model model) {
		Chef chef = chefService.findById(id);
		model.addAttribute("chef",chef);
		model.addAttribute("buffetsProposti",chef.getBuffetProposti());
		return "chefAdmin.html";
	}

	@GetMapping("/admin/chef")
	public String getFormChef(Model model){
		model.addAttribute("chef", new Chef());
		return "chefForm.html";
	}



	@GetMapping("/admin/toDeleteChef/{id}")
	public String toDeleteChef(@PathVariable("id") Long id, Model model) {
		model.addAttribute("chef",chefService.findById(id));
		return "riepilogoToDeleteChef.html";
	}



	@GetMapping("/admin/deleteChef/{id}")
	public String deleteChef(@PathVariable("id") Long id, Model model) {
		chefService.deleteById(id);
		model.addAttribute("chefs", chefService.findAll());
		return "chefsAdmin.html";
	}
}
