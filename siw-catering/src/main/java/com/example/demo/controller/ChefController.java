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

import com.example.demo.model.Chef;
import com.example.demo.service.ChefService;

@Controller
public class ChefController {
	@Autowired ChefService chefService;
	
	@GetMapping("/chef")
	public String getChefs (Model model) {
		List<Chef> chefs = chefService.findAll();
		model.addAttribute("chefs",chefs);
		return "chef.html";
	}
	
	@PostMapping("/chef")
	public String addChef(@Valid @ModelAttribute("chef") Chef chef, Model model,BindingResult bindingResult) {
	    chefService.save(chef);
	    model.addAttribute("chef",chef);
		return "chef.html";
	}
	
	@Transactional
	@GetMapping("/admin/deleteChef/{id}")
	public String deleteChef(@PathVariable("id") Long id, Model model) {
		chefService.deleteById(id);
		model.addAttribute("chef", chefService.findAll());
		return "chef.html";
	}
	
	@GetMapping("/admin/chef")
	public String getFormChef(Model model){
		model.addAttribute("chef", new Chef());
		return "chefForm.html";
	}
}
