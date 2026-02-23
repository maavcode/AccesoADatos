
package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.DireccionDTO;
import com.example.demo.model.Cliente;
import com.example.demo.model.Direccion;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.DireccionRepository;

@Service
public class DireccionServiceImpl implements DireccionService{

	@Autowired
	private DireccionRepository direccionRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;	

	@Override
	public List<DireccionDTO> listAllDireccionesByCliente(ClienteDTO clientedto) {
		// Obtenemos la lista de direcciones del cliente
		List<Direccion> lista = (List<Direccion>) direccionRepository.getDireccionesByCliente(clientedto.getIdCliente());
		// Creamos una lista de DireccionDTO que será la que devolvamos al controlador
		List<DireccionDTO> listaResultado = new ArrayList<DireccionDTO>();
		// Recorremos la lista de direcciones y las mapeamos a DTO
		for (int i = 0; i < lista.size(); ++i) {
		    listaResultado.add(DireccionDTO.convertToDTO(lista.get(i), clientedto));
		}
		// Devolvemos la lista de DTO's
		return listaResultado;
	}
	/*
	@Override
	public List<DireccionDTO> listAllDireccionesByCliente(ClienteDTO clientedto) {
		// Obtenemos la lista de direcciones del cliente
		Long id= clientedto.getIdCliente();
		
		Optional<Cliente> cliente=clienteRepository.findById(id);
		List<DireccionDTO> listaResultado = new ArrayList<DireccionDTO>();
		// Recorremos la lista de direcciones y las mapeamos a DTO
		for (Direccion d:cliente.get().getListaDirecciones()) {
		    listaResultado.add(DireccionDTO.convertToDTO(d, clientedto));
		}
		// Devolvemos la lista de DTO's
		return listaResultado;
	}
*/

	@Override
	public void saveNewDireccion(DireccionDTO direcciondto, ClienteDTO clientedto) {
		Optional<Cliente> cliente = clienteRepository.findById(clientedto.getIdCliente());
		if (cliente.isPresent()) {
			Direccion direccion = DireccionDTO.convertToEntity(direcciondto, cliente.get());
			cliente.get().getListaDirecciones().add(direccion);
			// Almacenamos la direccion, y por la relacion que tiene, almacenará la relacion N a N
			direccionRepository.save(direccion);
		}
	}

	@Override
	public List<DireccionDTO> listAllDirecciones() {
		List<Direccion> lista = direccionRepository.findAll();
		List<DireccionDTO> listaresultado = new ArrayList<DireccionDTO>();
		// Recorremos la lista de direcciones y las mapeamos a DTO
		for (int i = 0; i < lista.size(); ++i) {
			listaresultado.add(DireccionDTO.convertToDTO(lista.get(i),null));
		}		
		return listaresultado;
	}	
	
	@Override
	public DireccionDTO getDireccionById(Long id) {
		Optional<Direccion> direccion = direccionRepository.findById(id);
		if(direccion.isPresent()) {
			return DireccionDTO.convertToDTO(direccion.get(), null);
		}else {
			return null;			
		}
	}

}
