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
import com.example.demo.dto.CuentaDTO;
import com.example.demo.service.ClienteService;
import com.example.demo.service.CuentaService;

@Controller
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private ClienteService clienteService;	
	
    @RequestMapping("/clientes/{idCliente}/cuentas")
    public String listCuentasCliente(@PathVariable Long idCliente, Model model){
    	// Obtenemos el cliente para luego poner sus datos en la pantalla
    	ClienteDTO clientedto = clienteService.getClienteById(idCliente);    	
    	// Obtenemos la lista de cuentas
    	List<CuentaDTO> cuentas = cuentaService.listAllCuentas(clientedto);
    	// Pasamos los datos al modelo
        model.addAttribute("list", cuentas);
        model.addAttribute("clientedto", clientedto);
        // Mostramos la vista
        return "cuentascliente";
    } 	
    
    @RequestMapping("/clientes/{idCliente}/cuentas/new")
    public String newCuenta(@PathVariable Long idCliente, Model model){
    	// Obtenemos el cliente para luego poner sus datos en la pantalla
    	ClienteDTO clientedto = clienteService.getClienteById(idCliente);
    	// pasamos el cliente y la nueva cuenta a la vista
        model.addAttribute("clientedto", clientedto);
        model.addAttribute("cuentadto", new CuentaDTO());
        model.addAttribute("add", true);        
        return "cuentaform";    	
    }     
    
    @PostMapping("/clientes/{idCliente}/cuentas/save")
    public String saveCuenta(Model model, @PathVariable Long idCliente, @ModelAttribute("cuentadto") CuentaDTO cuentadto) {
    	// Obtenemos el cliente para luego poner sus datos en la pantalla
    	ClienteDTO clientedto = clienteService.getClienteById(idCliente);
    	// Asignamos a la cuenta el cliente
    	cuentadto.setClientedto(clientedto);
    	//clientedto.getListaCuentas().add(cuentadto);    	

    	// invocamos la operacion save a la capa de servicio de cuenta
    	cuentaService.saveCuenta(cuentadto);
    	return "redirect:/clientes/" + String.valueOf(idCliente) + "/cuentas";
    }      
}

