package pojos;

public class TipoUsuario {
	private Integer idtipousuario;
	private String nombre;
	
	public TipoUsuario(){}
	
	public TipoUsuario(Integer idtipousuario, String nombre){
		this.idtipousuario = idtipousuario;
		this.nombre = nombre;
	}
	
	public Integer getIdtipousuario() {
		return idtipousuario;
	}
	public void setIdtipousuario(Integer idtipousuario) {
		this.idtipousuario = idtipousuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "TipoUsuario [idtipousuario=" + idtipousuario + ", nombre="
				+ nombre + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idtipousuario == null) ? 0 : idtipousuario.hashCode());
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
		TipoUsuario other = (TipoUsuario) obj;
		if (idtipousuario == null) {
			if (other.idtipousuario != null)
				return false;
		} else if (!idtipousuario.equals(other.idtipousuario))
			return false;
		return true;
	}
}
