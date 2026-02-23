package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.EquipoDTO;

public interface EquipoService {
	List<EquipoDTO> listAllEquipos();
	void saveEquipo(EquipoDTO equipoDTO);
	EquipoDTO getEquipoByNombre(String n);
}
