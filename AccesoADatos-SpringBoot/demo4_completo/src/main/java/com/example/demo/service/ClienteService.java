package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.DireccionDTO;

public interface ClienteService {
	
	void saveCliente(ClienteDTO clienteDTO);
	ClienteDTO getClienteById(Long id);
	List<ClienteDTO> listAllClientes();
	void deleteCliente(Long id);
	void updateCliente(ClienteDTO clienteDTO);

	
}
