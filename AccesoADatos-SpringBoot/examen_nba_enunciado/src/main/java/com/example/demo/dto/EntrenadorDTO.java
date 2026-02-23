package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.demo.model.Entrenador;
import com.example.demo.model.Equipo;

import lombok.Data;
import lombok.ToString;

@Data
public class EntrenadorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dni;
    private String nombre;
    private Integer numeCarnet;
    private LocalDate fecha;

    @ToString.Exclude
    private EquipoDTO equipo;

    // ---------- Entidad -> DTO ----------
    public static EntrenadorDTO convertToDTO(Entrenador e) {
        EntrenadorDTO dto = new EntrenadorDTO();
        if (e == null) return dto;

        dto.setDni(e.getDni());
        dto.setNombre(e.getNombre());
        dto.setNumeCarnet(e.getNumeCarnet());
        dto.setFecha(e.getFecha());

        // >>> Aquí va el código que preguntabas <<<
        EquipoDTO equipoDTO = new EquipoDTO();
        Equipo equipo = e.getEquipo();
        if (equipo != null) {
            equipoDTO.setNombre(equipo.getNombre());
            // Si quieres más datos:
            // equipoDTO.setCiudad(equipo.getCiudad());
            // equipoDTO.setConferencia(equipo.getConferencia());
            // equipoDTO.setDivision(equipo.getDivision());
        }
        dto.setEquipo(equipoDTO);

        return dto;
    }

    // ---------- DTO -> Entidad ----------
    public static Entrenador convertToEntity(EntrenadorDTO dto) {
        Entrenador e = new Entrenador();
        if (dto == null) return e;

        e.setDni(dto.getDni());
        e.setNombre(dto.getNombre());
        e.setNumeCarnet(dto.getNumeCarnet());
        e.setFecha(dto.getFecha());
        // El Equipo (entidad) se asigna donde dispongas de la entidad (servicio)
        return e;
    }

}