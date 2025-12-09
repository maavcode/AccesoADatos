package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="equipo")
public class Equipo implements Serializable{
	@Id // CUANDO NO ES AUTOINCREMENTAL NO SE PONE LA ESTRATEGIA
	private String nomeq;
	private String director;
	
	// Equipo - Ciclista (1-N)
	@OneToMany(mappedBy = "equipo", fetch=FetchType.LAZY) 
	// GUARDA LA LISTA DE CICLISTAS, CUALES? LOS CICLISTAS QUE TENGAN GUARDADO EL MISMO EQUIPO (equipo) 
	// GUARDA TAMBIEN EL METODO FETCH, EN ESTE CASO CREARA SOLO LAS LISTAS QUE USARAS
	private List<Ciclista> ciclistas = new ArrayList<Ciclista>();
	
	// Equipo - Representante (1-1)
	@OneToOne(mappedBy = "equipo")
	private Representante representante;
	
	// Equipo - Coche (1-1)
	@OneToOne(mappedBy = "equipo")
	private Coche coche;

	public Equipo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipo(String nomeq, String director, List<Ciclista> ciclistas, Representante representante, Coche coche) {
		super();
		this.nomeq = nomeq;
		this.director = director;
		this.ciclistas = ciclistas;
		this.representante = representante;
		this.coche = coche;
	}

	public String getNomeq() {
		return nomeq;
	}

	public void setNomeq(String nomeq) {
		this.nomeq = nomeq;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<Ciclista> getCiclistas() {
		return ciclistas;
	}

	public void setCiclistas(List<Ciclista> ciclistas) {
		this.ciclistas = ciclistas;
	}

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}
	
	
}
