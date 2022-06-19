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
import com.example.demo.service.ChefService;
import com.example.demo.service.PiattoService;

@Controller
public class PortaleController {


//	@Autowired IngredientiService ingredienteService;

	
	@GetMapping("/")
	public String Home() {
		return "home.html";
	}
	
//					/{id}
	@GetMapping("/user")
	public String getUserPage(Model model) {
	    return "user.html";
	}
	

	

	
	@PostMapping("/admin/{id}")
	public String getAdminPage(Model model) {
		return "admin.html";
	}
	

	
//	@GetMapping("/admin/deleteBuffet/{id}")
//	public String toDeleteBuffet(@PathVariable("id") Long id, Model model) {
//	    model.addAttribute("buffet", this.buffetService.searchById(id));
//		return "toDeleteBuffet.html";
//	}
	
//	@GetMapping("/admin/deleteChef/{id}")
//	public String toDeleteChef(@PathVariable("id") Long id, Model model) {
//	    model.addAttribute("chef", this.chefService.findById(id));
//		return "toDeleteChef.html";
//	}

	
//	@GetMapping("/admin/deletePiatto/{id}")
//	public String toDeletePiatto(@PathVariable("id") String id, Model model) {
//	    model.addAttribute("piatto", this.piattoService.searchById(id));
//		return "toDeletePiatto.html";
//	}
	

}