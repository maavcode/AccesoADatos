package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;


import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "equipos")
public class Equipo {

    @Id
    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Ciudad")
    private String ciudad;

    @Column(name = "Conferencia")
    private String conferencia;

    @Column(name = "Division")
    private String division;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
    @ToString.Exclude
    private List<Entrenador> entrenadores = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
    @ToString.Exclude
    private List<Jugador> jugadores = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipoLocal")
    @ToString.Exclude
    private List<Partido> partidosComoLocal = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipoVisitante")
    @ToString.Exclude
    private List<Partido> partidosComoVisitante = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Equipo other = (Equipo) obj;
        if (nombre == null) {
            if (other.nombre != null) return false;
        } else if (!nombre.equals(other.nombre)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31; int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }
}
