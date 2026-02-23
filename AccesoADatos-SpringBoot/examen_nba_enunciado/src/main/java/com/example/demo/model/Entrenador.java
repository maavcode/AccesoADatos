package com.example.demo.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;


@Data
@Entity
@Table(name = "entrenadores")
public class Entrenador {

    @Id
    @Column(name = "dni")
    private String dni;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nume_carnet")
    private Integer numeCarnet;

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "equipos_Nombre", referencedColumnName = "Nombre")
    @ToString.Exclude
    private Equipo equipo;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Entrenador other = (Entrenador) obj;
        if (dni == null) {
            if (other.dni != null) return false;
        } else if (!dni.equals(other.dni)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31; int result = 1;
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
        return result;
    }
}
