package pojos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "material_deportivo")
public class MaterialDeportivo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	
	// Many to Many
	@ManyToMany
	@JoinTable(name = "partidos_material_deportivo", joinColumns = {@JoinColumn(name = "material_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "partido_id", referencedColumnName = "codigo")})
	private List<Partidos> partidos_materialDeportivo;
	

	public MaterialDeportivo() {}

	public MaterialDeportivo(Integer id, String nombre, String descripcion, List<Partidos> partidos_materialDeportivo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.partidos_materialDeportivo = partidos_materialDeportivo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Partidos> getPartidos_materialDeportivo() {
		return partidos_materialDeportivo;
	}

	public void setPartidos_materialDeportivo(List<Partidos> partidos_materialDeportivo) {
		this.partidos_materialDeportivo = partidos_materialDeportivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((partidos_materialDeportivo == null) ? 0 : partidos_materialDeportivo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof MaterialDeportivo))
			return false;
		MaterialDeportivo other = (MaterialDeportivo) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (partidos_materialDeportivo == null) {
			if (other.partidos_materialDeportivo != null)
				return false;
		} else if (!partidos_materialDeportivo.equals(other.partidos_materialDeportivo))
			return false;
		return true;
	}


}
