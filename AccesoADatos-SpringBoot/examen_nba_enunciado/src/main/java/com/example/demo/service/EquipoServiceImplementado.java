package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.EquipoDTO;
import com.example.demo.model.Equipo;
import com.example.demo.repository.EquipoRepository;

@Service
public class EquipoServiceImplementado implements EquipoService {

	@Autowired
	private EquipoRepository equipoRepository;
	
	@Override
	public List<EquipoDTO> listAllEquipos() {
		List<Equipo> listaEquipos = equipoRepository.findAll();

		List<EquipoDTO> listaResultado = new ArrayList<EquipoDTO>();
		for (Equipo equipo : listaEquipos) {
			listaResultado.add(EquipoDTO.convertToDTO(equipo));
		}
		return listaResultado;
	}

	@Override
	public void saveEquipo(EquipoDTO equipoDTO) {
		Equipo equipo = EquipoDTO.convertToEntity(equipoDTO);
		equipoRepository.save(equipo);
	}

	@Override
	public EquipoDTO getEquipoByNombre(String n) {
		Optional<Equipo> equipo = equipoRepository.getEquipoByNombre(n);
		if (equipo.isPresent()) {
			return EquipoDTO.convertToDTO(equipo.get());
		} else {
			return null;
		}
	}

}
