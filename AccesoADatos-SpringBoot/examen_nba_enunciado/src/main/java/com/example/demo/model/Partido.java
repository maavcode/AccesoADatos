package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "partidos")
public class Partido {

    // En la BD no es AUTO_INCREMENT
    @Id
    @Column(name = "codigo")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "equipo_local", referencedColumnName = "Nombre")
    @ToString.Exclude
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visitante", referencedColumnName = "Nombre")
    @ToString.Exclude
    private Equipo equipoVisitante;

    @Column(name = "puntos_local")
    private Integer puntosLocal;

    @Column(name = "puntos_visitante")
    private Integer puntosVisitante;

    @Column(name = "temporada")
    private String temporada;

    // En BD es VARCHAR(45)
    @Column(name = "fechahora")
    private String fechaHora;

    // N:N con material_deportivo (siguiendo tu estilo: EAGER + Cascade.ALL)
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(
        name = "partidos_material_deportivo",
        joinColumns = @JoinColumn(name = "partido_id"),
        inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    @ToString.Exclude
    private List<MaterialDeportivo> materiales = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Partido other = (Partido) obj;
        if (codigo == null) {
            if (other.codigo != null) return false;
        } else if (!codigo.equals(other.codigo)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31; int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }
}