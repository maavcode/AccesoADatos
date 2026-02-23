package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.DireccionDTO;

public interface DireccionService {

	List<DireccionDTO> listAllDireccionesByCliente(ClienteDTO clientedto);
	void saveNewDireccion(DireccionDTO direccion, ClienteDTO clientedto);
	List<DireccionDTO> listAllDirecciones();
	DireccionDTO getDireccionById(Long id);

}
