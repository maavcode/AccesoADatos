package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utensilio")
public class Utensilio implements Serializable{
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_utensilio;
	
	private String nombre;
	
	// Utensilio - Receta (N:N)
	@ManyToMany
	@JoinTable( 
			name = "receta_utensilio",
			joinColumns = { 
					@JoinColumn(name = "id_utensilio", referencedColumnName = "id_utensilio") 
			}, 
			inverseJoinColumns = { 
					@JoinColumn(name = "id_receta", referencedColumnName = "id_receta") 
																								
					}
			)
	private List<Receta> recetas = new ArrayList<Receta>();

	public Utensilio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utensilio(Integer id_utensilio, String nombre, List<Receta> recetas) {
		super();
		this.id_utensilio = id_utensilio;
		this.nombre = nombre;
		this.recetas = recetas;
	}

	public Integer getId_utensilio() {
		return id_utensilio;
	}

	public void setId_utensilio(Integer id_utensilio) {
		this.id_utensilio = id_utensilio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_utensilio, nombre, recetas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utensilio other = (Utensilio) obj;
		return Objects.equals(id_utensilio, other.id_utensilio) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(recetas, other.recetas);
	}

	@Override
	public String toString() {
		return "Utensilio [id_utensilio=" + id_utensilio + ", nombre=" + nombre + ", recetas=" + recetas + "]";
	}
	
	
}
