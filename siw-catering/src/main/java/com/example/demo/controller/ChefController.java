package com.example.demo.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.ChefService;

@Controller
public class ChefController {
	@Autowired ChefService chefService;
	
	@GetMapping("/chef")
	public String getChef () {
		return "chef.html";
	}
	
	@PostMapping("/admin/chef")
	public String addChef (@PathVariable("id") Long id, Model model) {
	    model.addAttribute("chef", this.chefService.findById(id));
		return "chef.html";
	}
	
	@Transactional
	@GetMapping("/admin/deleteChef/{id}")
	public String deleteChef(@PathVariable("id") Long id, Model model) {
		chefService.deleteById(id);
		model.addAttribute("chef", chefService.findAll());
		return "chef.html";
	}
}
