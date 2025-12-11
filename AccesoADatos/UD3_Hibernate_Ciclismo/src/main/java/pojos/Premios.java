package pojos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="premios")
public class Premios {
	@Id
	private Integer codigo;
	private String descripcion;
	private Integer cantidad;
	
	// Premios - Ciclista (N-N)
	@ManyToMany 
	@JoinTable( // Referenciamos una tabla intermedia y especificamos lo que tiene. 
			name="gana", // La tabla se llama gana
			joinColumns= {
					@JoinColumn (name="premio",referencedColumnName="codigo") // Tiene una propiedad premio que referencia a codigo
					},
			inverseJoinColumns= {
					@JoinColumn (name="dorsal",referencedColumnName="dorsal") // Tiene una propiedad dorsal que referencia a dorsal
					}
			) 
	private List<Ciclista> ciclistas=new ArrayList<Ciclista>();

	public Premios() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Premios(Integer codigo, String descripcion, Integer cantidad, List<Ciclista> ciclistas) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.ciclistas = ciclistas;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public List<Ciclista> getCiclistas() {
		return ciclistas;
	}

	public void setCiclistas(List<Ciclista> ciclistas) {
		this.ciclistas = ciclistas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, ciclistas, codigo, descripcion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Premios other = (Premios) obj;
		return Objects.equals(cantidad, other.cantidad) && Objects.equals(ciclistas, other.ciclistas)
				&& Objects.equals(codigo, other.codigo) && Objects.equals(descripcion, other.descripcion);
	}

	
}
