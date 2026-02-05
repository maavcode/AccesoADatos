package com.example.demo.model;

import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "organismos")
public class Organismo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String nombre;

    @Column(columnDefinition = "text")
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ComunidadAutonomaID")
    @JsonBackReference
    private ComunidadAutonoma comunidadAutonoma;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ResponsableID")
    @JsonBackReference
    private Responsable responsable;

    @OneToMany(mappedBy = "organismo")
    @JsonManagedReference
    private Set<Parque> parques;

	public Organismo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organismo(Integer iD, String nombre, String descripcion, ComunidadAutonoma comunidadAutonoma,
			Responsable responsable, Set<Parque> parques) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.comunidadAutonoma = comunidadAutonoma;
		this.responsable = responsable;
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

	public Set<Parque> getParques() {
		return parques;
	}

	public void setParques(Set<Parque> parques) {
		this.parques = parques;
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
		Organismo other = (Organismo) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(comunidadAutonoma, other.comunidadAutonoma)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(parques, other.parques) && Objects.equals(responsable, other.responsable);
	}

    // Getters y Setters, Constructores, hashCode, equals
}
