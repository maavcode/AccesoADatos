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
@Table(name = "menu")
public class Menu implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_menu;
	
	private Double precio;
	
	// Menu - Plato (N:N)
	@ManyToMany
	@JoinTable( 
			name = "menu_plato",
			joinColumns = { 
					@JoinColumn(name = "id_menu", referencedColumnName = "id_menu")  
			}, 
			inverseJoinColumns = { 
					@JoinColumn(name = "id_plato", referencedColumnName = "id_plato")																		
					}
			)
	private List<Plato> platos = new ArrayList<Plato>();

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(Integer id_menu, Double precio, List<Plato> platos) {
		super();
		this.id_menu = id_menu;
		this.precio = precio;
		this.platos = platos;
	}

	public Integer getId_menu() {
		return id_menu;
	}

	public void setId_menu(Integer id_menu) {
		this.id_menu = id_menu;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public List<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_menu, platos, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		return Objects.equals(id_menu, other.id_menu) && Objects.equals(platos, other.platos)
				&& Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Menu [id_menu=" + id_menu + ", precio=" + precio + ", platos=" + platos + "]";
	}
	
	
	
}
