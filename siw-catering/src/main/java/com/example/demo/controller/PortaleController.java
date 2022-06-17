package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.BuffetService;
import com.example.demo.service.ChefService;
import com.example.demo.service.PiattoService;

@Controller
public class PortaleController {
	@Autowired BuffetService buffetService;
	@Autowired ChefService chefService;
//	@Autowired IngredientiService ingredienteService;
	@Autowired PiattoService piattoService;
	
	@PostMapping("/home")
	public String Home() {
		return "home.html";
	}
	
	@GetMapping("/user/{id}")
	public String getUserPage(Model model) {
	    return "user.html";
	}

	@GetMapping("/buffet")
	public String getBuffet() {
		return "buffet.html";
	}
	
	@GetMapping("/buffet/{id}/piatti")
	public String getPiattiDiBuffet() {
		return "buffetid.html";
	}
	
	@GetMapping("/chef")
	public String getChef () {
		return "chef.html";
	}
	
	@GetMapping("/piatti")
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
	
	@PostMapping("/admin/{id}")
	public String getAdminPage(Model model) {
		return "admin.html";
	}
	
	@PostMapping("/admin/buffet")
	public String addBuffet(@PathVariable("id") Long id, Model model) {
	    model.addAttribute("buffet", this.buffetService.findById(id));
		return "buffet.html";
	}
	
	@GetMapping("/admin/deleteBuffet/{id}")
	public String toDeleteBuffet(@PathVariable("id") Long id, Model model) {
	    model.addAttribute("buffet", this.buffetService.findById(id));
		return "toDeleteBuffet.html";
	}
	
	@GetMapping("/admin/deleteBuffet/{id}")
	public String toDeleteBuffet(@PathVariable("id") Long id, Model model) {
		buffetService.deleteById(id);
		model.addAttribute("buffet", buffetService.findAll());
		return "buffet.html";
	}
	
	@PostMapping("/admin/chef")
	public String addChef (@PathVariable("id") Long id, Model model) {
	    model.addAttribute("chef", this.chefService.findById(id));
		return "chef.html";
	}
	
	@GetMapping("/admin/deleteChef/{id}")
	public String toDeleteChef(@PathVariable("id") Long id, Model model) {
	    model.addAttribute("chef", this.chefService.findById(id));
		return "toDeleteChef.html";
	}
	
	@GetMapping("/admin/deleteChef/{id}")
	public String toDeleteBuffet(@PathVariable("id") Long id, Model model) {
		chefService.deleteById(id);
		model.addAttribute("chef", chefService.findAll());
		return "chef.html";
	}
	
	@PostMapping("/admin/piatto")
	public String addPiatto(@PathVariable("id") Long id, Model model) {
	    model.addAttribute("piatto", this.piattoService.findById(id));
		return "piatto.html";
	}
	
	@GetMapping("/admin/deletePiatto/{id}")
	public String toDeletePiatto(@PathVariable("id") Long id, Model model) {
	    model.addAttribute("piatto", this.piattoService.findById(id));
		return "toDeletePiatto.html";
	}
	
	@GetMapping("/admin/deletePiatto/{id}")
	public String toDeletePiatto(@PathVariable("id") Long id, Model model) {
		piattoService.deleteById(id);
		model.addAttribute("piatto", piattoService.findAll());
		return "piatto.html";
	}
}