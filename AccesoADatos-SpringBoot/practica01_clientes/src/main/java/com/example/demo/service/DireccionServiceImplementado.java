package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.DireccionDTO;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.model.Cliente;
import com.example.demo.model.Direccion;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.DireccionRepository;

@Service
public class DireccionServiceImplementado implements DireccionService{

	@Autowired
	private DireccionRepository direccionRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<DireccionDTO> listAllDireccionesCliente(ClienteDTO clienteDTO) {
		List<Direccion> lista = direccionRepository.getDireccionesByCliente(clienteDTO.getIdCliente());
		List<DireccionDTO> listaResultados = new ArrayList<DireccionDTO>();
		
		for (Direccion direccion : lista) {
			listaResultados.add(DireccionDTO.convertToDTO(direccion, clienteDTO));
		}
		
		return listaResultados;
	}

	@Override
	public void saveDireccion(DireccionDTO direccionDTO, ClienteDTO clienteAsociado) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteAsociado.getIdCliente());
		if (cliente.isPresent()) {
			Direccion direccion = DireccionDTO.convertToEntity(direccionDTO, cliente.get() );
			cliente.get().getListaDirecciones().add(direccion);
			direccionRepository.save(direccion);
		} 
		
		
	}

}
