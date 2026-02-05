package com.example.demo.model;

import java.util.List;


import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="organismos")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ID")
public class Organismos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String nombre;

    @Column(columnDefinition = "text")
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ComunidadAutonomaID")
    @JsonBackReference(value = "comunidad_organismo")
    private ComunidadAutonoma comunidadAutonoma;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ResponsableID")
    @JsonBackReference (value = "responsable_organismo")// Evita la recursividad en la relación
    private Responsable responsable;
    
    @OneToMany(mappedBy="organismo")
    @JsonManagedReference(value = "organismo_parque")
    private Set<Parque> parques;
  
    // Getters y Setters
    public Integer getId() {
        return ID;
    }

    public void setId(Integer id) {
        this.ID = id;
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

    public ComunidadAutonoma getComunidadAutonoma() {
        return comunidadAutonoma;
    }

    public void setComunidadAutonoma(ComunidadAutonoma comunidadAutonoma) {
        this.comunidadAutonoma = comunidadAutonoma;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

	public Organismos(Integer iD, String nombre, String descripcion, ComunidadAutonoma comunidadAutonoma,
			Responsable responsable, Set<Parque> parques) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.comunidadAutonoma = comunidadAutonoma;
		this.responsable = responsable;
		this.parques = parques;
	}

	public Organismos() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, comunidadAutonoma, descripcion, nombre, parques, responsable);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organismos other = (Organismos) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(comunidadAutonoma, other.comunidadAutonoma)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(parques, other.parques) && Objects.equals(responsable, other.responsable);
	}
    
}
