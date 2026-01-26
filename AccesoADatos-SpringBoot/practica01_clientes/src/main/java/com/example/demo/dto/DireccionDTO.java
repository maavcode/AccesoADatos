package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Cliente;
import com.example.demo.model.Direccion;

import lombok.Data;
import lombok.ToString;

@Data
public class DireccionDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idDireccion;	
	private String descripcion;
	private String pais;
	private String cp;
	@ToString.Exclude	
    private List<ClienteDTO> listaClientes;
	
	public static DireccionDTO convertToDTO(Direccion direccion, ClienteDTO clientedto) {
		DireccionDTO direcciondto = new DireccionDTO();
		direcciondto.setIdDireccion(direccion.getId());
		direcciondto.setDescripcion(direccion.getDescripcion());
		direcciondto.setPais(direccion.getPais());
		direcciondto.setCp(direccion.getCp());
		
		// No tiene sentido mapear todos los clientes que tiene la direccion, puesto que
		// al mapear cada cliente volveriamos a mapear sus direcciones, y así sucesivamente.
		direcciondto.getListaClientes().add(clientedto);
		
		return direcciondto;
	}

	public static Direccion convertToEntity(DireccionDTO direcciondto, Cliente cliente) {
		Direccion direccion = new Direccion();
		direccion.setId(direcciondto.getIdDireccion());
		direccion.setDescripcion(direcciondto.getDescripcion());
		direccion.setPais(direcciondto.getPais());
		direccion.setCp(direcciondto.getCp());
		
		// No tiene sentido mapear todos los clientes que tiene la direccion, puesto que
		// al mapear cada cliente volveriamos a mapear sus direcciones, y así sucesivamente.		
		direccion.getListaClientes().add(cliente);
		
		return direccion;
		
	}	

	// Constructor vacio
	public DireccionDTO() {
		super();
		this.listaClientes = new ArrayList<ClienteDTO>();
	}	
}
