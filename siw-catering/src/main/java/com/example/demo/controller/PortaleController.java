package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PortaleController {
	
	@GetMapping("/")
	public String Home() {
		return "user.html";
	}
	
	@GetMapping("/admin")
	public String getAdminPage(Model model) {
	    return "admin.html";
	}
	
	@GetMapping("/contatti")
	public String getContattiPage(Model model) {
	    return "contatti.html";
	}	
}