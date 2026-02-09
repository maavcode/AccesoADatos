package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.DireccionDTO;
import com.example.demo.service.ClienteService;
import com.example.demo.service.DireccionService;

@Controller
public class DireccionController {
	@Autowired
	private DireccionService direccionService;
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/clientes/{idCliente}/direcciones/")
	public String direccionesCliente(Model model, @PathVariable Long idCliente) {
		ClienteDTO clientedto = clienteService.getClienteById(idCliente);
		List<DireccionDTO> direcciones = direccionService.listAllDireccionesCliente(clientedto);
		model.addAttribute("list", direcciones);
		model.addAttribute("clientedto", clientedto);
		
		return "direccionescliente";
	}
	
	@RequestMapping("/clientes/{idCliente}/direcciones/new/")
	public String newCliente(Model model, @PathVariable Long idCliente) {
		ClienteDTO buscarCliente= clienteService.getClienteById(idCliente);
		model.addAttribute("direcciondto", new DireccionDTO() );
		model.addAttribute("clientedto", buscarCliente );
		return "direccionform";
	}
	
	@PostMapping("/clientes/{idCliente}/direcciones/save/")
	public String saveCliente(Model model, @ModelAttribute("direcciondto") DireccionDTO direccionDTO, @PathVariable Long idCliente) {
		ClienteDTO clienteAsociado = clienteService.getClienteById(idCliente);
		
		clienteAsociado.getListaDirecciones().add(direccionDTO);
		direccionDTO.getListaClientes().add(clienteAsociado);
		
		direccionService.saveDireccion(direccionDTO, clienteAsociado );
		return "redirect:/clientes/{idCliente}/direcciones/";
	}
	
	
}
