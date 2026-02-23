package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public void saveCliente(ClienteDTO clienteDTO) {
		Cliente cliente = ClienteDTO.convertToEntity(clienteDTO);
		clienteRepository.save(cliente); // Hace INSERT
	}
	
	@Override
    @Transactional // 🔥 IMPORTANTE: Necesario para que merge() funcione
	public void updateCliente(ClienteDTO clienteDTO) {
		Cliente cliente = ClienteDTO.convertToEntity(clienteDTO);
		Optional<Cliente> clienteExistente = clienteRepository.findById(cliente.getId());
	        if (clienteExistente.isPresent()) {
	            Cliente clientem = clienteExistente.get();
	            clientem.setApellidos(cliente.getApellidos());
	            clientem.setNombre(cliente.getNombre());
	            clientem.setClaveSeguridad(cliente.getClaveSeguridad());
	            clientem.setEmail(cliente.getEmail());
	            clientem.setNif(cliente.getNif());
	            clienteRepository.save(clientem);
	        } else {
	            // Manejo de la situación cuando el cliente no se encuentra
	        	   clienteRepository.save(cliente); // Hace INSERT
	        }
		
	}
	@Override
	public ClienteDTO getClienteById(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.isPresent()) {
			return ClienteDTO.convertToDTO(cliente.get());
		}else {
			return null;			
		}
	}

	@Override
	public List<ClienteDTO> listAllClientes() {
		List<Cliente> lista = clienteRepository.findAll();
		List<ClienteDTO> listaResultado = new ArrayList<ClienteDTO>();
		for (int i = 0; i < lista.size(); ++i) {
		    listaResultado.add(ClienteDTO.convertToDTO(lista.get(i)));
		}
		return listaResultado;
	}

	@Override
	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
	}
}



