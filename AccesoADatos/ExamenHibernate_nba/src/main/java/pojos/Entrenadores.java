package pojos;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entrenadores")
public class Entrenadores {

	@Id
	private String dni;
	private String nombre;
	private Integer nume_carnet;
	private Date fecha;
	
	// One to One
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "equipos_Nombre")
	private Equipos equipos_entrenadores;

	
	public Entrenadores() {}


	public Entrenadores(String dni, String nombre, Integer nume_carnet, Date fecha, Equipos equipos_entrenadores) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.nume_carnet = nume_carnet;
		this.fecha = fecha;
		this.equipos_entrenadores = equipos_entrenadores;
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


	public Integer getNume_carnet() {
		return nume_carnet;
	}


	public void setNume_carnet(Integer nume_carnet) {
		this.nume_carnet = nume_carnet;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Equipos getEquipos_entrenadores() {
		return equipos_entrenadores;
	}


	public void setEquipos_entrenadores(Equipos equipos_entrenadores) {
		this.equipos_entrenadores = equipos_entrenadores;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((equipos_entrenadores == null) ? 0 : equipos_entrenadores.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((nume_carnet == null) ? 0 : nume_carnet.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Entrenadores))
			return false;
		Entrenadores other = (Entrenadores) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (equipos_entrenadores == null) {
			if (other.equipos_entrenadores != null)
				return false;
		} else if (!equipos_entrenadores.equals(other.equipos_entrenadores))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nume_carnet == null) {
			if (other.nume_carnet != null)
				return false;
		} else if (!nume_carnet.equals(other.nume_carnet))
			return false;
		return true;
	}



	
}
