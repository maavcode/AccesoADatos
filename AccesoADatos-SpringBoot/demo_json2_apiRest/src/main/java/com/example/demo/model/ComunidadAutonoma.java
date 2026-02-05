package com.example.demo.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "comunidadesautonomas")
public class ComunidadAutonoma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String nombre;

    @OneToMany(mappedBy = "comunidadAutonoma")
    @JsonBackReference
    private Set<Organismo> organismos;

    @OneToMany(mappedBy = "comunidadAutonoma")
    @JsonBackReference
    private Set<Parque> parques;

	public ComunidadAutonoma() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComunidadAutonoma(Integer iD, String nombre, Set<Organismo> organismos, Set<Parque> parques) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.organismos = organismos;
		this.parques = parques;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Organismo> getOrganismos() {
		return organismos;
	}

	public void setOrganismos(Set<Organismo> organismos) {
		this.organismos = organismos;
	}

	public Set<Parque> getParques() {
		return parques;
	}

	public void setParques(Set<Parque> parques) {
		this.parques = parques;
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

    // Getters y Setters, Constructores, hashCode, equals
    
    
}
