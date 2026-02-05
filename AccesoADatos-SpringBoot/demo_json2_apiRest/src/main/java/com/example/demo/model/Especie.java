package com.example.demo.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "especies")
public class Especie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String nombre;

    @Column(columnDefinition = "text")
    private String descripcion;
    private String tipo;

    @ManyToMany
    @JoinTable(
        name = "parques_especies",
        joinColumns = @JoinColumn(name = "EspecieID"),
        inverseJoinColumns = @JoinColumn(name = "ParqueID")
    )
    @JsonIgnore
    private List<Parque> parques = new ArrayList<>();

	public Especie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Especie(Integer iD, String nombre, String descripcion, String tipo, List<Parque> parques) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Parque> getParques() {
		return parques;
	}

	public void setParques(List<Parque> parques) {
		this.parques = parques;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, descripcion, nombre, parques, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especie other = (Especie) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(parques, other.parques)
				&& Objects.equals(tipo, other.tipo);
	}

    // Getters y Setters, Constructores, hashCode, equals
    
}
