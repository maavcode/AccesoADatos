package pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipos")
public class Equipos {

	@Id
	private String Nombre;
	private String Ciudad;
	private String Conferencia;
	private String Division;
	
	//One to many
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "equipos_partidos_v")
	private List<Partidos> partidos_visitante;
	
	//One to many
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "equipos_partidos_l")
	private List<Partidos> partidos_local;
	
	//One to many
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "equipos_jugadores")
	private List<Jugadores> jugadores;
	
	//One to One
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "equipos_entrenadores")
	private Entrenadores entrenadores;

	
	public Equipos() {}

	public Equipos(String nombre, String ciudad, String conferencia, String division, List<Partidos> partidos_visitante,
			List<Partidos> partidos_local, List<Jugadores> jugadores, Entrenadores entrenadores) {
		super();
		Nombre = nombre;
		Ciudad = ciudad;
		Conferencia = conferencia;
		Division = division;
		this.partidos_visitante = partidos_visitante;
		this.partidos_local = partidos_local;
		this.jugadores = jugadores;
		this.entrenadores = entrenadores;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getCiudad() {
		return Ciudad;
	}


	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}


	public String getConferencia() {
		return Conferencia;
	}


	public void setConferencia(String conferencia) {
		Conferencia = conferencia;
	}


	public String getDivision() {
		return Division;
	}


	public void setDivision(String division) {
		Division = division;
	}


	public List<Partidos> getPartidos_visitante() {
		return partidos_visitante;
	}


	public void setPartidos_visitante(List<Partidos> partidos_visitante) {
		this.partidos_visitante = partidos_visitante;
	}


	public List<Partidos> getPartidos_local() {
		return partidos_local;
	}


	public void setPartidos_local(List<Partidos> partidos_local) {
		this.partidos_local = partidos_local;
	}


	public List<Jugadores> getJugadores() {
		return jugadores;
	}


	public void setJugadores(List<Jugadores> jugadores) {
		this.jugadores = jugadores;
	}


	public Entrenadores getEntrenadores() {
		return entrenadores;
	}


	public void setEntrenadores(Entrenadores entrenadores) {
		this.entrenadores = entrenadores;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ciudad == null) ? 0 : Ciudad.hashCode());
		result = prime * result + ((Conferencia == null) ? 0 : Conferencia.hashCode());
		result = prime * result + ((Division == null) ? 0 : Division.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((entrenadores == null) ? 0 : entrenadores.hashCode());
		result = prime * result + ((jugadores == null) ? 0 : jugadores.hashCode());
		result = prime * result + ((partidos_local == null) ? 0 : partidos_local.hashCode());
		result = prime * result + ((partidos_visitante == null) ? 0 : partidos_visitante.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Equipos))
			return false;
		Equipos other = (Equipos) obj;
		if (Ciudad == null) {
			if (other.Ciudad != null)
				return false;
		} else if (!Ciudad.equals(other.Ciudad))
			return false;
		if (Conferencia == null) {
			if (other.Conferencia != null)
				return false;
		} else if (!Conferencia.equals(other.Conferencia))
			return false;
		if (Division == null) {
			if (other.Division != null)
				return false;
		} else if (!Division.equals(other.Division))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (entrenadores == null) {
			if (other.entrenadores != null)
				return false;
		} else if (!entrenadores.equals(other.entrenadores))
			return false;
		if (jugadores == null) {
			if (other.jugadores != null)
				return false;
		} else if (!jugadores.equals(other.jugadores))
			return false;
		if (partidos_local == null) {
			if (other.partidos_local != null)
				return false;
		} else if (!partidos_local.equals(other.partidos_local))
			return false;
		if (partidos_visitante == null) {
			if (other.partidos_visitante != null)
				return false;
		} else if (!partidos_visitante.equals(other.partidos_visitante))
			return false;
		return true;
	}

	
	
}
