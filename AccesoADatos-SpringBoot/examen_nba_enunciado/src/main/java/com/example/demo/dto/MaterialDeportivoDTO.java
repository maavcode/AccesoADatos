package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.MaterialDeportivo;
import com.example.demo.model.Partido;

import lombok.Data;
import lombok.ToString;

@Data
public class MaterialDeportivoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nombre;
    private String descripcion;

    @ToString.Exclude
    private List<PartidoDTO> partidos;

    // ---------- Entidad -> DTO ----------
    public static MaterialDeportivoDTO convertToDTO(MaterialDeportivo m) {
        MaterialDeportivoDTO dto = new MaterialDeportivoDTO();
        if (m == null) return dto;

        dto.setId(m.getId());
        dto.setNombre(m.getNombre());
        dto.setDescripcion(m.getDescripcion());
        // Partidos: evitamos recursión; si necesitas, puedes llenar shallow
        return dto;
    }

    // Variante para añadir back-reference controlada desde PartidoDTO
    public static MaterialDeportivoDTO convertToDTO(MaterialDeportivo m, PartidoDTO partidoDTO) {
        MaterialDeportivoDTO dto = convertToDTO(m);
        if (partidoDTO != null) {
            dto.getPartidos().add(partidoDTO);
        }
        return dto;
    }

    // ---------- DTO -> Entidad ----------
    public static MaterialDeportivo convertToEntity(MaterialDeportivoDTO dto) {
        MaterialDeportivo m = new MaterialDeportivo();
        if (dto == null) return m;

        m.setId(dto.getId());
        m.setNombre(dto.getNombre());
        m.setDescripcion(dto.getDescripcion());
        // Relación N:N se gestionará en PartidoDTO.convertToEntity(...)
        return m;
    }

    // Constructor vacío
    public MaterialDeportivoDTO() {
        super();
        this.partidos = new ArrayList<>();
    }
}