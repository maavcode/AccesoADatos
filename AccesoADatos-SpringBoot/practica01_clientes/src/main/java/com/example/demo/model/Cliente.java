package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nif")
	private String nif;

	@Column(name = "nombre")
	private String nombre;
	private String apellidos;
	
	@Column(name = "claveseguridad")
	private String claveSeguridad;
	private String email;
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "cliente")
	@ToString.Exclude
	private Recomendacion recomendacion;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente")
	@ToString.Exclude
	private List<Cuenta> listaCuentas;
	
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name="clientesdirecciones", // Tabla que mantiene la relacion N-N
        joinColumns=@JoinColumn(name="idcliente"), // columna que almacena el id de cliente en la tabla clientes-direcciones
        inverseJoinColumns=@JoinColumn(name="iddireccion")) // columna que almacena el id de la direccion en la tabla clientes-direcciones
	@ToString.Exclude
    private List<Direccion> listaDirecciones;
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
}

