package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ClienteDTO;

public interface ClienteService {
	void saveCliente(ClienteDTO clientDTO);
	ClienteDTO getClienteById(Long id);
	List<ClienteDTO> listAllClientes();
	void deleteClient(Long id);
	
}
