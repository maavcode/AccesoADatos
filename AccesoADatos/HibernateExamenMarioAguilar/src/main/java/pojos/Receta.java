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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "receta")
public class Receta implements Serializable{
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_receta;
	
	private Integer tiempo_total;
	
	// Receta - Plato (1:1)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_plato")
	private Plato plato;
	
	// Receta - Utensilio (N:N)
	@ManyToMany
	@JoinTable( 
			name = "receta_utensilio",
			joinColumns = { 
					@JoinColumn(name = "id_receta", referencedColumnName = "id_receta") 
			}, 
			inverseJoinColumns = { 
					@JoinColumn(name = "id_utensilio", referencedColumnName = "id_utensilio") 
																								
					}
			)
	private List<Utensilio> utensilios = new ArrayList<Utensilio>();

	public Receta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Receta(Integer id_receta, Integer tiempo_total, Plato plato, List<Utensilio> utensilios) {
		super();
		this.id_receta = id_receta;
		this.tiempo_total = tiempo_total;
		this.plato = plato;
		this.utensilios = utensilios;
	}

	public Integer getId_receta() {
		return id_receta;
	}

	public void setId_receta(Integer id_receta) {
		this.id_receta = id_receta;
	}

	public Integer getTiempo_total() {
		return tiempo_total;
	}

	public void setTiempo_total(Integer tiempo_total) {
		this.tiempo_total = tiempo_total;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public List<Utensilio> getUtensilios() {
		return utensilios;
	}

	public void setUtensilios(List<Utensilio> utensilios) {
		this.utensilios = utensilios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_receta, plato, tiempo_total, utensilios);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receta other = (Receta) obj;
		return Objects.equals(id_receta, other.id_receta) && Objects.equals(plato, other.plato)
				&& Objects.equals(tiempo_total, other.tiempo_total) && Objects.equals(utensilios, other.utensilios);
	}

	@Override
	public String toString() {
		return "Receta [id_receta=" + id_receta + ", tiempo_total=" + tiempo_total + ", plato=" + plato
				+ ", utensilios=" + utensilios + "]";
	}
	
	
}
