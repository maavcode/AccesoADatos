package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.DireccionDTO;
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

}
