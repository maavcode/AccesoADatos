package pojo;

import java.util.Objects;

public class Grupo {
	private Integer idGrupo;
	private String nombre;
	public Grupo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grupo(Integer idGrupo, String nombre) {
		super();
		this.idGrupo = idGrupo;
		this.nombre = nombre;
	}
	public Integer getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idGrupo, nombre);
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
		return Objects.equals(idGrupo, other.idGrupo) && Objects.equals(nombre, other.nombre);
	}
	
	public int compareTo(Object obj) {
		Grupo other = (Grupo) obj;
		return idGrupo.compareTo(other.idGrupo);
	}
	
}
