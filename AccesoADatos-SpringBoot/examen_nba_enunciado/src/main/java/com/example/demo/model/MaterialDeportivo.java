package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "material_deportivo")
public class MaterialDeportivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    // Lado inverso del N:N
    @ManyToMany(mappedBy = "materiales", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Partido> partidos = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        MaterialDeportivo other = (MaterialDeportivo) obj;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31; int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}