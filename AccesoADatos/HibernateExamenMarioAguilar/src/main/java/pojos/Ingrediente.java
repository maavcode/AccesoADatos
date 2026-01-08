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
@Table(name = "ingrediente")
public class Ingrediente implements Serializable{
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_ingrediente;
	
	private String nombre;
	private Integer calorias;
	
	// Ingrediente - Plato (1:N)
	@OneToMany(mappedBy = "ingrediente", fetch = FetchType.LAZY)
	private List<Plato> platos = new ArrayList<Plato>();

	public Ingrediente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ingrediente(Integer id_ingrediente, String nombre, Integer calorias, List<Plato> platos) {
		super();
		this.id_ingrediente = id_ingrediente;
		this.nombre = nombre;
		this.calorias = calorias;
		this.platos = platos;
	}

	public Integer getId_ingrediente() {
		return id_ingrediente;
	}

	public void setId_ingrediente(Integer id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCalorias() {
		return calorias;
	}

	public void setCalorias(Integer calorias) {
		this.calorias = calorias;
	}

	public List<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(calorias, id_ingrediente, nombre, platos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		return Objects.equals(calorias, other.calorias) && Objects.equals(id_ingrediente, other.id_ingrediente)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(platos, other.platos);
	}

	@Override
	public String toString() {
		return "Ingrediente [id_ingrediente=" + id_ingrediente + ", nombre=" + nombre + ", calorias=" + calorias
				+ ", platos=" + platos + "]";
	}
	
	
	
}
