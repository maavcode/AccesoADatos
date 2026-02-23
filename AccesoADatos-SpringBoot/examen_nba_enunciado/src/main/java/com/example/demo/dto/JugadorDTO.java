package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.model.Equipo;
import com.example.demo.model.Jugador;

import lombok.Data;
import lombok.ToString;

@Data
public class JugadorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer codigo;
    private String nombre;
    private String altura;
    private String posicion;
    private String nacimiento; // en BD es VARCHAR(45)

    @ToString.Exclude
    private EquipoDTO equipo;

    // ---------- Entidad -> DTO ----------
    public static JugadorDTO convertToDTO(Jugador j) {
        JugadorDTO dto = new JugadorDTO();
        if (j == null) return dto;

        dto.setCodigo(j.getCodigo());
        dto.setNombre(j.getNombre());
        dto.setAltura(j.getAltura());
        dto.setPosicion(j.getPosicion());
        dto.setNacimiento(j.getNacimiento());

        // >>> Aquí va el código que preguntabas <<<
        EquipoDTO equipoDTO = new EquipoDTO();
        Equipo equipo = j.getEquipo();
        if (equipo != null) {
            equipoDTO.setNombre(equipo.getNombre());
            // Rellenar más si quieres:
            // equipoDTO.setCiudad(equipo.getCiudad());
            // equipoDTO.setConferencia(equipo.getConferencia());
            // equipoDTO.setDivision(equipo.getDivision());
        }
        dto.setEquipo(equipoDTO);

        return dto;
    }

    // ---------- DTO -> Entidad ----------
    public static Jugador convertToEntity(JugadorDTO dto) {
        Jugador j = new Jugador();
        if (dto == null) return j;

        j.setCodigo(dto.getCodigo());
        j.setNombre(dto.getNombre());
        j.setAltura(dto.getAltura());
        j.setPosicion(dto.getPosicion());
        j.setNacimiento(dto.getNacimiento());
        // La relación con Equipo (entidad) se resuelve en el service
        return j;
    }

    public JugadorDTO() {
        super();
        this.equipo = new EquipoDTO();
    }
}