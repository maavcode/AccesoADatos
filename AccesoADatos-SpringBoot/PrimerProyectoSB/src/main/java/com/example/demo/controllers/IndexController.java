package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	@GetMapping("/") // Cuando este en / (index)
	@ResponseBody
	public String helloWorld() {
		return "HelloWorld";
	}
	
}
