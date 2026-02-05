package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.service.ClienteService;

import org.springframework.beans.factory.annotation.Value;

@Controller
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	@Value("${aplicacion.nombre}")
	private String nombreAplicacion;
	@Value("${asignatura}")
	private String nombreAsignatura;
	
	private ClienteDTO buscarCliente = new ClienteDTO();
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", nombreAplicacion);
		model.addAttribute("nombreAsignarura", nombreAsignatura);
		return "index";
	}
	
	@RequestMapping("/clientes")
	public String listaClientes(Model model) {
		model.addAttribute("list", clienteService.listAllClientes());
		return "clientes";
	}
	
	@RequestMapping("/clientes/new")
	public String newCliente(Model model) {
		model.addAttribute("clientedto", new ClienteDTO());
		model.addAttribute("add", true);
		return "clienteform";
	}
	
	@PostMapping("/clientes/save")
	public String saveCliente(
			Model model, 
			@ModelAttribute("clientedto") ClienteDTO clienteDTO
			) {
		
		clienteService.saveCliente(clienteDTO);
		return "redirect:/clientes";
	}
	
	@RequestMapping("/clientes/{idCliente}")
	public String infoCliente(@PathVariable Long idCliente, Model model){
		buscarCliente= clienteService.getClienteById(idCliente);
		model.addAttribute("clientedto", buscarCliente);
		return "clienteshow";
	}
	
	@RequestMapping("/clientes/delete/{idCliente}")
	public String eliminarCliente(@PathVariable Long idCliente, Model model){
		clienteService.deleteClient(idCliente);
		return "redirect:/clientes";
	}
	// Recoge informacion para update
	@RequestMapping("/clientes/update/{idCliente}")
	public String actualizarCliente(@PathVariable Long idCliente, Model model){
		buscarCliente= clienteService.getClienteById(idCliente);
		model.addAttribute("clientedto", buscarCliente);
		model.addAttribute("add", false);
		return "clienteformedit";
	}
	// cuando le das a actualizar te lleva a clientes
	@PostMapping("/clientes/saveupdate/{idCliente}")
	public String guardar_actualizarCliente(@PathVariable Long idCliente, @ModelAttribute ClienteDTO clientedto) {
		clienteService.updateCliente(clientedto);
		return "redirect:/clientes";
	}
	
}
