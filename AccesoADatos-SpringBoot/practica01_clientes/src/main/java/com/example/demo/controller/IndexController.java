package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	// AQUI SE HACE EL ROUTING
	
	@GetMapping("/")
	@ResponseBody
	public String holaMundo() {
		return "Hola mundo";
	
	}	
	
	@GetMapping(value="/helloModel")
	public String printHello(Model model) {
		
		model.addAttribute("mensaje", "hola view");
		return "helloView";		
	
	}	
	
}
