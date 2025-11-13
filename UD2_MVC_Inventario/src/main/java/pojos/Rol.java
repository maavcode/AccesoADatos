package pojos;

public class Rol {
	private Integer idrol;
	private String nombre;
	private String descripcion;
	public Rol(){}
	public Rol(Integer idRol, String nombre, String descripcion){
		this.idrol = idRol;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public Integer getIdrol() {
		return idrol;
	}
	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
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
	@Override
	public String toString() {
		return "Rol [idrol=" + idrol + ", nombre=" + nombre + ", descripcion="
				+ descripcion + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idrol == null) ? 0 : idrol.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		if (idrol == null) {
			if (other.idrol != null)
				return false;
		} else if (!idrol.equals(other.idrol))
			return false;
		return true;
	}
	
}
