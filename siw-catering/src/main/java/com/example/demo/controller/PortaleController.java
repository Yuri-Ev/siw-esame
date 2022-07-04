package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PortaleController {


//	@Autowired IngredientiService ingredienteService;

	
	@GetMapping("/")
	public String Home() {
		return "user.html";
	}
	
//					/{id}
	@GetMapping("/admin")
	public String getUserPage(Model model) {
	    return "home.html";
	}
	
	@GetMapping("/contatti")
	public String getContattiPage(Model model) {
	    return "contatti.html";
	}	

	
	@PostMapping("/admin/{id}")
	public String getAdminPage(Model model) {
		return "admin.html";
	}
	

	
//	
//	@GetMapping("/admin/buffet")
//	public String getDatiBuffet(Model model){
//		model.addAttribute("buffet", new Buffet());
//		return "buffetForm.html";
//	}
	
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