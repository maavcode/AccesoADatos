package com.example.demo.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Table(name="parquesnaturales")
public class Parque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    
    private String nombre;
    private BigDecimal extension;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "comunidad_autonomaid")
    @JsonBackReference(value = "comunidad_parque")
    private ComunidadAutonoma comunidadAutonoma;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OrganismoID") 
    @JsonBackReference(value = "organismo_parque")
    private Organismos organismo;

    @ManyToMany
    @JoinTable(
        name = "parques_especies",
        joinColumns = @JoinColumn(name = "ParqueID"),
        inverseJoinColumns = @JoinColumn(name = "EspecieID")
    )
    private List<Especie> especies;


    
	public Parque() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parque(Integer iD, String nombre, BigDecimal extension, ComunidadAutonoma comunidadAutonoma,
			Organismos organismo, List<Especie> especies) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.extension = extension;
		this.comunidadAutonoma = comunidadAutonoma;
		this.organismo = organismo;
		this.especies = especies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, comunidadAutonoma, especies, extension, nombre, organismo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parque other = (Parque) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(comunidadAutonoma, other.comunidadAutonoma)
				&& Objects.equals(especies, other.especies) && Objects.equals(extension, other.extension)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(organismo, other.organismo);
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

	public BigDecimal getExtension() {
		return extension;
	}

	public void setExtension(BigDecimal extension) {
		this.extension = extension;
	}

	public ComunidadAutonoma getComunidadAutonoma() {
		return comunidadAutonoma;
	}

	public void setComunidadAutonoma(ComunidadAutonoma comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}

	public Organismos getOrganismo() {
		return organismo;
	}

	public void setOrganismo(Organismos organismo) {
		this.organismo = organismo;
	}

	public List<Especie> getEspecies() {
		return especies;
	}

	public void setEspecies(List<Especie> especies) {
		this.especies = especies;
	}

	@Override
	public String toString() {
		return "Parque [ID=" + ID + ", nombre=" + nombre + ", extension=" + extension + ", comunidadAutonoma="
				+ comunidadAutonoma + ", organismo=" + organismo + ", especies=" + especies + "]";
	}
    
    
}
