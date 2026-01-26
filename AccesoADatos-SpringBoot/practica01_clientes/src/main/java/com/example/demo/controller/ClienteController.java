package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Value;

@Controller
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	@Value("${aplicacion.nombre}")
	private String nombreAplicacion;
	@Value("${asignatura}")
	private String nombreAsignatura;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", nombreAplicacion);
		model.addAttribute("nombreAsignarura", nombreAsignatura);
	}
	
	@RequestMapping("/clientes")
	public String listClientes(Model model) {
		model.addAllAttributes("list", clienteService.listAllClientes());
		return "clientes";
	}
}
