package pojo;

import java.util.Objects;

public class Departamento {
	
	private Integer idDepartamento;
	private String nombre;
	
	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departamento(Integer idDepartamento, String nombre) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
	}
	
	public Integer getIdDepartamento() {
		return idDepartamento;
	}
	
	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idDepartamento, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(idDepartamento, other.idDepartamento) && Objects.equals(nombre, other.nombre);
	}
	
	public int compareTo(Object obj) {
		Departamento other = (Departamento) obj;
		return idDepartamento.compareTo(other.idDepartamento);
	}
	
	
}
