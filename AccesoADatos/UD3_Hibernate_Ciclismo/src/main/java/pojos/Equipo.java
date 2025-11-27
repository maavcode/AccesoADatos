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
import javax.persistence.Table;



@Entity
@Table(name="equipo")
public class Equipo implements Serializable{
	@Id // CUANDO NO ES AUTOINCREMENTAL NO SE PONE LA ESTRATEGIA
	private String nomeq;
	private String director;
	
	@OneToMany(mappedBy = "equipo", fetch=FetchType.LAZY) 
	// GUARDA LA LISTA DE CICLISTAS, CUALES? LOS CICLISTAS QUE TENGAN GUARDADO EL MISMO EQUIPO (equipo) 
	// GUARDA TAMBIEN EL METODO FETCH, EN ESTE CASO CREARA SOLO LAS LISTAS QUE USARAS
	private List<Ciclista> ciclistas = new ArrayList<Ciclista>();
	
	public Equipo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipo(String nomeq, String director) {
		super();
		this.nomeq = nomeq;
		this.director = director;
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

	@Override
	public int hashCode() {
		return Objects.hash(ciclistas, director, nomeq);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(ciclistas, other.ciclistas) && Objects.equals(director, other.director)
				&& Objects.equals(nomeq, other.nomeq);
	}

	@Override
	public String toString() {
		return "Equipo [nomeq=" + nomeq + ", director=" + director + ", ciclistas=" + ciclistas + "]";
	}
	
	
	
}
