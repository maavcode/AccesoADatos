package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.service.ClienteService;

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
    	model.addAttribute("nombreAsignatura", nombreAsignatura);
        return "index";
    }   	

    @RequestMapping("/clientes/new")
    public String newCliente(Model model){
        model.addAttribute("clientedto", new ClienteDTO());
        model.addAttribute("add", true);
        return "clienteform";
    }   
    
    @RequestMapping("/clientes/update/{idCliente}")
    public String updateCliente(@PathVariable Long idCliente, Model model){
        model.addAttribute("clientedto", clienteService.getClienteById(idCliente));
        model.addAttribute("add", false);
        return "clienteformedit";
    }       

    @PostMapping("/clientes/save")
    public String saveCliente(Model model, @ModelAttribute("clientedto") ClienteDTO clienteDTO) {
    	// invocamos la operacion save a la capa de servicio de cliente
    	clienteService.saveCliente(clienteDTO);
    	return "redirect:/clientes";
    }  
    
    @PostMapping("/clientes/saveupdate/{idCliente}")
    public String actualizaCliente(@PathVariable Long idCliente,
    		@ModelAttribute ClienteDTO clientedto) {
    	// invocamos la operacion save a la capa de servicio de cliente
    	//ClienteDTO  clienteDTO= clienteService.getClienteById(idCliente);
    	//clientedto.setIdCliente(null);
    	clienteService.updateCliente(clientedto);
    	return "redirect:/clientes";
    } 
    
    @RequestMapping("/clientes/{idCliente}")
    public String showClienteById(@PathVariable Long idCliente, Model model){
        model.addAttribute("clientedto", clienteService.getClienteById(idCliente));
        return "clienteshow";
    }    
     
    @RequestMapping("/clientes")
    public String listClientes(Model model){
        model.addAttribute("list", clienteService.listAllClientes());
        return "clientes";
    } 
    
    @RequestMapping("/clientes/delete/{idCliente}")
    public String deleteCliente(@PathVariable Long idCliente){
    	clienteService.deleteCliente(idCliente);
    	return "redirect:/clientes";
    }    
}
