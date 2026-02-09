package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.DireccionDTO;
import com.example.demo.model.Cliente;

public interface DireccionService {
	List<DireccionDTO> listAllDireccionesCliente(ClienteDTO clienteDTO);
	void saveDireccion(DireccionDTO direccionDTO, ClienteDTO clienteAsociado);
}
