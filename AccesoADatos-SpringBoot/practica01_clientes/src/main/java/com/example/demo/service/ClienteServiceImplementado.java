package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteServiceImplementado implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	// Ejemplo01: Listar todos los clientes
	@Override
	public List<ClienteDTO> listAllClientes() {
		List<Cliente> listaClientes = clienteRepository.findAll();
		
		List<ClienteDTO> listaResultado = new ArrayList<ClienteDTO>();
		for (Cliente cliente : listaClientes) {
			listaResultado.add(ClienteDTO.convertToDTO(cliente));
		}
		return listaResultado;
	}
	
	
	// Ejemplo02: Insertar un Cliente
	@Override
	public void saveCliente(ClienteDTO clientDTO) {
		Cliente cliente = ClienteDTO.convertToEntity(clientDTO);
		clienteRepository.save(cliente);
		
	}

	@Override
	public ClienteDTO getClienteById(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return ClienteDTO.convertToDTO(cliente.get());
		} else {
			return null;
		}
	}

	

	@Override
	public void deleteClient(Long id) {
		clienteRepository.deleteById(id);
		
	}


	@Override
	public void updateCliente(ClienteDTO clienteDto) {
		Cliente cliente = clienteDto.convertToEntity(clienteDto);
		Optional <Cliente> clienteExistente = clienteRepository.findById(cliente.getId());
		if (clienteExistente.isPresent()) {
			// Sustituir por constructor
			Cliente clienteBd = clienteExistente.get();
			clienteBd.setApellidos(cliente.getApellidos());
			clienteBd.setNombre(cliente.getNombre());
			clienteBd.setClaveSeguridad(cliente.getClaveSeguridad());
			clienteBd.setEmail(cliente.getEmail());
			clienteBd.setNif(cliente.getNif());
			clienteRepository.save(clienteBd);
		} else {
			clienteRepository.save(cliente);
		}
	}
	
}
