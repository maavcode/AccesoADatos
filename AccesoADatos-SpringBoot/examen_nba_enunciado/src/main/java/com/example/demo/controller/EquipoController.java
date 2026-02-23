package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.EquipoDTO;
import com.example.demo.service.EquipoService;

@Controller
public class EquipoController {
	@Autowired
	private EquipoService equipoService;
	
	private EquipoDTO buscarEquipo = new EquipoDTO();

	@RequestMapping("/equipos")
	public String listaEquipos(Model model) {
		model.addAttribute("list", equipoService.listAllEquipos());
		return "equipos";
	}
	
	@RequestMapping("/equipos/new")
	public String newCliente(Model model) {
		model.addAttribute("equipo", new EquipoDTO());
		model.addAttribute("add", true);
		return "equipoform";
	}
	
	@PostMapping("/equipos/save")
	public String saveCliente(
			Model model, 
			@ModelAttribute("equipo") EquipoDTO equipoDTO
			) {
		
		equipoService.saveEquipo(equipoDTO);
		return "redirect:/equipos";
	}
	
	@RequestMapping("/equipos/{n}/jugadores")
	public String jugadoresEquipo(@PathVariable String n, Model model){
		buscarEquipo = equipoService.getEquipoByNombre(n);
		model.addAttribute("equipo", buscarEquipo);
		return "equiposhow";
	}
}
