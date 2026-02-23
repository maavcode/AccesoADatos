package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/clientes/{idCliente}/direcciones")
    public String listDireccionesCliente(@PathVariable Long idCliente, Model model){
    	// Obtenemos el cliente para luego poner sus datos en la pantalla
    	ClienteDTO clientedto = clienteService.getClienteById(idCliente);    	
    	// Obtenemos la lista de direcciones del cliente
    	List<DireccionDTO> direcciones = direccionService.listAllDireccionesByCliente(clientedto);
    	// Pasamos los datos al modelo
        model.addAttribute("list", direcciones);
        model.addAttribute("clientedto", clientedto);
        // Mostramos la vista
        return "direccionescliente";
    }
    
    
    
    
    @RequestMapping("/clientes/{idCliente}/direcciones/new/")
    public String newDireccion(@PathVariable Long idCliente, Model model){  
    	ClienteDTO clientedto = clienteService.getClienteById(idCliente); 
    	DireccionDTO direcciondto = new DireccionDTO();
        model.addAttribute("direcciondto", direcciondto);
        model.addAttribute("clientedto", clientedto);
        return "direccionform";
    }       
    
    @PostMapping("/clientes/{idCliente}/direcciones/save")
    public String saveDireccion(@PathVariable Long idCliente, @ModelAttribute("direcciondto") DireccionDTO direcciondto, Model model) {    	
    	ClienteDTO clientedto = clienteService.getClienteById(idCliente);
    	clientedto.getListaDirecciones().add(direcciondto);    	
    	direcciondto.getListaClientes().add(clientedto);
    	direccionService.saveNewDireccion(direcciondto, clientedto);
    	return "redirect:/clientes/" + String.valueOf(idCliente) + "/direcciones";
    }            
  
    @PostMapping("/clientes/{idCliente}/direcciones/saveDireccion_add")
    public String saveDireccion_add(@PathVariable Long idCliente, @RequestParam("idDireccion") Long idDireccion, Model model) {
        DireccionDTO direcciondto = direccionService.getDireccionById(idDireccion);
        ClienteDTO clientedto = clienteService.getClienteById(idCliente);
        clientedto.getListaDirecciones().add(direcciondto);
        direcciondto.getListaClientes().add(clientedto);
        direccionService.saveNewDireccion(direcciondto, clientedto);
        return "redirect:/clientes/" + idCliente + "/direcciones/";
    }
    
    @RequestMapping("/clientes/{idCliente}/direcciones/add/")
    public String addDireccion(@PathVariable Long idCliente, Model model){  
    	ClienteDTO clientedto = clienteService.getClienteById(idCliente); 
    	List<DireccionDTO> lista = direccionService.listAllDirecciones();
        model.addAttribute("lista", lista);
        model.addAttribute("clientedto", clientedto);
        return "direccionaddform";
    }     
}




