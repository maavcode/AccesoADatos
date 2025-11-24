package pojos;

public class Grupo {
	private String idgrupo;
	private String nombre;
	
	public Grupo(){}
	
	public Grupo(String idgrupo, String nombre){
		this.idgrupo = idgrupo;
		this.nombre = nombre;
	}
	
	public String getIdgrupo() {
		return idgrupo;
	}
	public void setIdgrupo(String idgrupo) {
		this.idgrupo = idgrupo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Grupo [idgrupo=" + idgrupo + ", nombre=" + nombre + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idgrupo == null) ? 0 : idgrupo.hashCode());
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
		Grupo other = (Grupo) obj;
		if (idgrupo == null) {
			if (other.idgrupo != null)
				return false;
		} else if (!idgrupo.equals(other.idgrupo))
			return false;
		return true;
	}
	

	

}
