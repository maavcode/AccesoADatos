package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.model.Equipo;

import lombok.Data;

@Data
public class EquipoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    // PK
    private String nombre;

    private String ciudad;
    private String conferencia;
    private String division;

    // ---------- Entidad -> DTO ----------
    public static EquipoDTO convertToDTO(Equipo e) {
        EquipoDTO dto = new EquipoDTO();
        if (e == null) return dto;

        dto.setNombre(e.getNombre());
        dto.setCiudad(e.getCiudad());
        dto.setConferencia(e.getConferencia());
        dto.setDivision(e.getDivision());
        return dto;
    }

    // ---------- DTO -> Entidad ----------
    public static Equipo convertToEntity(EquipoDTO dto) {
        Equipo e = new Equipo();
        if (dto == null) return e;

        e.setNombre(dto.getNombre());
        e.setCiudad(dto.getCiudad());
        e.setConferencia(dto.getConferencia());
        e.setDivision(dto.getDivision());
        return e;
    }

    // Constructor vacío
    public EquipoDTO() {
        super();
    }
}