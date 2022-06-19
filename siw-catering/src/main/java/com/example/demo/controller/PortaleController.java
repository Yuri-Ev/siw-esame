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
	@Autowired BuffetService buffetService;
	@Autowired ChefService chefService;
//	@Autowired IngredientiService ingredienteService;
	@Autowired PiattoService piattoService;
	
	@GetMapping("/")
	public String Home() {
		return "home.html";
	}
	
//					/{id}
	@GetMapping("/user")
	public String getUserPage(Model model) {
	    return "user.html";
	}

	@GetMapping("/buffet")
	public String getBuffet(Model model) {
		List<Buffet> buffets = buffetService.findAll();
		model.addAttribute("buffets", buffets);
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
	
	@PostMapping("/admin/{id}")
	public String getAdminPage(Model model) {
		return "admin.html";
	}
	
	@PostMapping("/buffet")
	public String addBuffet(@Valid @ModelAttribute("buffet") Buffet buffet, Model model,BindingResult bindingResult) {
	    buffetService.save(buffet);
	    model.addAttribute("buffet",buffet);
		return "buffet.html";
	}
	
	
	@GetMapping("/admin/buffet")
	public String getDatiBuffet(Model model){
		model.addAttribute("buffet", new Buffet());
		return "buffetForm.html";
	}
	
//	@GetMapping("/admin/deleteBuffet/{id}")
//	public String toDeleteBuffet(@PathVariable("id") Long id, Model model) {
//	    model.addAttribute("buffet", this.buffetService.searchById(id));
//		return "toDeleteBuffet.html";
//	}
	
	@Transactional
	@GetMapping("/admin/deleteBuffet/{id}")
	public String deleteBuffet(@PathVariable("id") Long id, Model model) {
		buffetService.deleteById(id);
		model.addAttribute("buffet", buffetService.findAll());
		return "buffet.html";
	}
	
	@PostMapping("/admin/chef")
	public String addChef (@PathVariable("id") Long id, Model model) {
	    model.addAttribute("chef", this.chefService.findById(id));
		return "chef.html";
	}
	
//	@GetMapping("/admin/deleteChef/{id}")
//	public String toDeleteChef(@PathVariable("id") Long id, Model model) {
//	    model.addAttribute("chef", this.chefService.findById(id));
//		return "toDeleteChef.html";
//	}
	
	@Transactional
	@GetMapping("/admin/deleteChef/{id}")
	public String deleteChef(@PathVariable("id") Long id, Model model) {
		chefService.deleteById(id);
		model.addAttribute("chef", chefService.findAll());
		return "chef.html";
	}
	
	@PostMapping("/admin/piatto")
	public String addPiatto(@PathVariable("id") String id, Model model) {
	    model.addAttribute("piatto", this.piattoService.searchById(id));
		return "piatto.html";
	}
	
//	@GetMapping("/admin/deletePiatto/{id}")
//	public String toDeletePiatto(@PathVariable("id") String id, Model model) {
//	    model.addAttribute("piatto", this.piattoService.searchById(id));
//		return "toDeletePiatto.html";
//	}
	
	@Transactional
	@GetMapping("/admin/deletePiatto/{id}")
	public String deletePiatto(@PathVariable("id") String id, Model model) {
		piattoService.deleteById(id);
		model.addAttribute("piatto", piattoService.findAll());
		return "piatto.html";
	}
}