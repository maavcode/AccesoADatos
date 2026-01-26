package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Cliente;
import com.example.demo.model.Cuenta;
import com.example.demo.model.Direccion;
import com.example.demo.model.Recomendacion;

import lombok.Data;
import lombok.ToString;

@Data
public class ClienteDTO implements Serializable{
		
	private static final long serialVersionUID = 1L;
	private long idCliente;
	private String nif;
	private String nombre;
	private String apellidos;
	private String claveSeguridad;
	private String email;
	@ToString.Exclude
	private RecomendacionDTO recomendacion;
	@ToString.Exclude
	private List<CuentaDTO> listaCuentas;
	@ToString.Exclude
	private List<DireccionDTO> listaDirecciones;
	
	// Convierte una entidad a un objeto DTO con todos los datos
	public static ClienteDTO convertToDTO(Cliente cliente) {
		// Creamos el clienteDTO y asignamos los valores basicos
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setIdCliente(cliente.getId());
		clienteDTO.setNif(cliente.getNif());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setApellidos(cliente.getApellidos());
		clienteDTO.setClaveSeguridad(cliente.getClaveSeguridad());
		clienteDTO.setEmail(cliente.getEmail());
		// Asignamos la recomendacion pasandole el clienteDTO como parámetro
		clienteDTO.setRecomendacion(RecomendacionDTO.convertToDTO(cliente.getRecomendacion(), clienteDTO));
		// Cargamos la lista de cuentas
		for(int i=0;i<cliente.getListaCuentas().size();i++) {
			CuentaDTO cuentadto = CuentaDTO.convertToDTO(cliente.getListaCuentas().get(i), clienteDTO);
			clienteDTO.getListaCuentas().add(cuentadto);			
		}
		// Cargamos la lista de direcciones
		for(int i=0;i<cliente.getListaDirecciones().size();i++) {
			DireccionDTO direcciondto = DireccionDTO.convertToDTO(cliente.getListaDirecciones().get(i), clienteDTO);
			clienteDTO.getListaDirecciones().add(direcciondto);			
		}
		
		return clienteDTO;
	}		
	
	// Convierte de un objeto a un entidad
	public static Cliente convertToEntity(ClienteDTO clientedto) {
		// Creamos el clientey asignamos los valores basicos
		Cliente  cliente = new Cliente();
		cliente.setId(clientedto.getIdCliente());
		cliente.setNif(clientedto.getNif());
		cliente.setNombre(clientedto.getNombre());
		cliente.setApellidos(clientedto.getApellidos());
		cliente.setClaveSeguridad(clientedto.getClaveSeguridad());
		cliente.setEmail(clientedto.getEmail());
		// Asignamos la recomendacion pasandole el cliente como parámetro	
		cliente.setRecomendacion(RecomendacionDTO.convertToEntity(clientedto.getRecomendacion(), cliente));
		// Cargamos la lista de cuentas
		for(int i=0;i<clientedto.getListaCuentas().size();i++) {
			Cuenta cuenta = CuentaDTO.convertToEntity(clientedto.getListaCuentas().get(i));
			cliente.getListaCuentas().add(cuenta);			
		}		
		// Cargamos la lista de direcciones
		for(int i=0;i<clientedto.getListaDirecciones().size();i++) {
			Direccion direccion = DireccionDTO.convertToEntity(clientedto.getListaDirecciones().get(i), cliente);
			cliente.getListaDirecciones().add(direccion);			
		}
		
		return cliente;
	}		
	
	// Constructor vacio
	public ClienteDTO() {
		super();
		this.recomendacion = new RecomendacionDTO();
		this.listaCuentas = new ArrayList<CuentaDTO>();
		this.listaDirecciones = new ArrayList<DireccionDTO>();
	}
}
