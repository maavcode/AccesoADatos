package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Equipo;
import com.example.demo.model.MaterialDeportivo;
import com.example.demo.model.Partido;

import lombok.Data;
import lombok.ToString;

@Data
public class PartidoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer codigo;
    private Integer puntosLocal;
    private Integer puntosVisitante;
    private String temporada;
    private String fechaHora; // en BD es VARCHAR(45)

    @ToString.Exclude
    private EquipoDTO equipoLocal;

    @ToString.Exclude
    private EquipoDTO equipoVisitante;

    @ToString.Exclude
    private List<MaterialDeportivoDTO> materiales;

    // ---------- Entidad -> DTO ----------
    public static PartidoDTO convertToDTO(Partido p) {
        PartidoDTO dto = new PartidoDTO();
        if (p == null) return dto;

        dto.setCodigo(p.getCodigo());
        dto.setPuntosLocal(p.getPuntosLocal());
        dto.setPuntosVisitante(p.getPuntosVisitante());
        dto.setTemporada(p.getTemporada());
        dto.setFechaHora(p.getFechaHora());

        // >>> Equipo local
        EquipoDTO equipoLocalDTO = new EquipoDTO();
        Equipo el = p.getEquipoLocal();
        if (el != null) {
            equipoLocalDTO.setNombre(el.getNombre());
            // equipoLocalDTO.setCiudad(el.getCiudad());
            // equipoLocalDTO.setConferencia(el.getConferencia());
            // equipoLocalDTO.setDivision(el.getDivision());
        }
        dto.setEquipoLocal(equipoLocalDTO);

        // >>> Equipo visitante
        EquipoDTO equipoVisitanteDTO = new EquipoDTO();
        Equipo ev = p.getEquipoVisitante();
        if (ev != null) {
            equipoVisitanteDTO.setNombre(ev.getNombre());
            // equipoVisitanteDTO.setCiudad(ev.getCiudad());
            // equipoVisitanteDTO.setConferencia(ev.getConferencia());
            // equipoVisitanteDTO.setDivision(ev.getDivision());
        }
        dto.setEquipoVisitante(equipoVisitanteDTO);

        // Materiales
        if (p.getMateriales() != null) {
            for (MaterialDeportivo m : p.getMateriales()) {
                MaterialDeportivoDTO mdto = new MaterialDeportivoDTO();
                mdto.setId(m.getId());
                mdto.setNombre(m.getNombre());
                mdto.setDescripcion(m.getDescripcion());
                dto.getMateriales().add(mdto);
            }
        }

        return dto;
    }

    // ---------- DTO -> Entidad ----------
    public static Partido convertToEntity(PartidoDTO dto) {
        Partido p = new Partido();
        if (dto == null) return p;

        p.setCodigo(dto.getCodigo());
        p.setPuntosLocal(dto.getPuntosLocal());
        p.setPuntosVisitante(dto.getPuntosVisitante());
        p.setTemporada(dto.getTemporada());
        p.setFechaHora(dto.getFechaHora());
        // Equipos y materiales (entidades) se resuelven en el service
        return p;
    }

    public PartidoDTO() {
        super();
        this.equipoLocal = new EquipoDTO();
        this.equipoVisitante = new EquipoDTO();
        this.materiales = new ArrayList<>();
    }
}