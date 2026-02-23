package com.example.demo.model;

import javax.persistence.*;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Altura")
    private String altura;

    @Column(name = "Posicion")
    private String posicion;

    @ManyToOne
    @JoinColumn(name = "Nombre_equipo", referencedColumnName = "Nombre")
    @ToString.Exclude
    private Equipo equipo;

    // En la BD es VARCHAR(45); lo mantenemos como String
    @Column(name = "nacimiento")
    private String nacimiento;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Jugador other = (Jugador) obj;
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
