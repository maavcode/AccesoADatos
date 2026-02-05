package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="responsables")
public class Responsable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String dni;
    private String nombre;
    private String telefono;
    
    
    @OneToOne(fetch = FetchType.EAGER, mappedBy="responsable")
     // @JsonBackReference // Evita la recursividad en la relación
    @JsonBackReference(value = "responsable_organismo")
    private Organismos organismo;

    
	public Responsable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Responsable(Integer iD, String dni, String nombre, String telefono, Organismos organismo) {
		super();
		ID = iD;
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.organismo = organismo;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Organismos getOrganismo() {
		return organismo;
	}

	public void setOrganismo(Organismos organismo) {
		this.organismo = organismo;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Responsable other = (Responsable) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(dni, other.dni) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(organismo, other.organismo) && Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Responsable [ID=" + ID + ", dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", organismo=" + organismo + "]";
	}

}
