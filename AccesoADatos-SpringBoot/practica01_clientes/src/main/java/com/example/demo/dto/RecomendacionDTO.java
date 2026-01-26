package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.model.Cliente;
import com.example.demo.model.Recomendacion;

import lombok.Data;
import lombok.ToString;

@Data
public class RecomendacionDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Long idRecomendacion;
	private String observaciones;
	@ToString.Exclude
	private ClienteDTO clientedto;
	
	
	public static RecomendacionDTO convertToDTO(Recomendacion recomendacion, ClienteDTO cliente) {
		
		RecomendacionDTO recomendacionDTO = new RecomendacionDTO();
		recomendacionDTO.setIdRecomendacion(recomendacion.getId());
		recomendacionDTO.setObservaciones(recomendacion.getObservaciones());
		recomendacionDTO.setClientedto(cliente);
		
		return recomendacionDTO;
	}


	public static Recomendacion convertToEntity(RecomendacionDTO recomendaciondto, Cliente cliente) {
		
		Recomendacion recomendacion = new Recomendacion();
		recomendacion.setId(recomendaciondto.getIdRecomendacion());
		recomendacion.setObservaciones(recomendaciondto.getObservaciones());
		recomendacion.setCliente(cliente);
		
		return recomendacion;
	}
}
