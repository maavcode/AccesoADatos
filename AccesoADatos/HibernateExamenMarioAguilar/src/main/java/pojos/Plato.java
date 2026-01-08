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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plato")
public class Plato implements Serializable{
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_plato;

	private String nombre;
	private String tipo;

	// Plato - Ingrediente (N:1)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ingrediente_principal")
	private Ingrediente ingrediente;

	// Plato - Menu (N:N)
	@ManyToMany
	@JoinTable( 
			name = "menu_plato",
			joinColumns = { 
					@JoinColumn(name = "id_plato", referencedColumnName = "id_plato") 
			}, 
			inverseJoinColumns = { 
					@JoinColumn(name = "id_menu", referencedColumnName = "id_menu") 
																								
					}
			)
	private List<Menu> menus = new ArrayList<Menu>();

	// Plato - Receta (1:1)
	@OneToOne(mappedBy = "plato")
	private Receta receta;

	public Plato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plato(Integer id_plato, String nombre, String tipo, Ingrediente ingrediente, List<Menu> menus,
			Receta receta) {
		super();
		this.id_plato = id_plato;
		this.nombre = nombre;
		this.tipo = tipo;
		this.ingrediente = ingrediente;
		this.menus = menus;
		this.receta = receta;
	}

	public Integer getId_plato() {
		return id_plato;
	}

	public void setId_plato(Integer id_plato) {
		this.id_plato = id_plato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(id_plato, ingrediente, menus, nombre, receta, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plato other = (Plato) obj;
		return Objects.equals(id_plato, other.id_plato) && Objects.equals(ingrediente, other.ingrediente)
				&& Objects.equals(menus, other.menus) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(receta, other.receta) && Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return "Plato [id_plato=" + id_plato + ", nombre=" + nombre + ", tipo=" + tipo + ", ingrediente=" + ingrediente
				+ ", menus=" + menus + ", receta=" + receta + "]";
	}

	
}
