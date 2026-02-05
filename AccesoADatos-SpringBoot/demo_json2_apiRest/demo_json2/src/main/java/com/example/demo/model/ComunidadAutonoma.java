package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="comunidadesautonomas")
public class ComunidadAutonoma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String nombre;

    @OneToMany(mappedBy = "comunidadAutonoma")
    @JsonBackReference(value = "comunidad_organismo")
    private Set<Organismos> organismos;

    @OneToMany(mappedBy = "comunidadAutonoma")
    @JsonBackReference(value = "comunidad_parque")
    private Set<Parque> parques;

    // Getters y Setters
    
   
    public ComunidadAutonoma(Integer iD, String nombre, Set<Organismos> organismos, Set<Parque> parques) {
		super();
		this.ID = iD;
		this.nombre = nombre;
		this.organismos = organismos;
		this.parques = parques;
	}
    
	public ComunidadAutonoma() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, nombre, organismos, parques);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComunidadAutonoma other = (ComunidadAutonoma) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(organismos, other.organismos) && Objects.equals(parques, other.parques);
	}


	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		this.ID = iD;
	}

	
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Organismos> getOrganismos() {
        return organismos;
    }

    public void setOrganismos(Set<Organismos> organismos) {
        this.organismos = organismos;
    }

    public Set<Parque> getParques() {
        return parques;
    }

    public void setParques(Set<Parque> parques) {
        this.parques = parques;
    }
}
