package pojos;

public class Departamento {

	private Integer iddepartamento;
	private String nombre;

	public Departamento() {
		super();
	}

	public Departamento(Integer iddepartamento, String nombre) {
		super();
		this.iddepartamento = iddepartamento;
		this.nombre = nombre;
	}

	public int comapreTo(Object obj) {
		Departamento other = (Departamento) obj;
		return iddepartamento.compareTo(other.iddepartamento);
	}

	@Override
	public String toString() {
		return "Departamento [iddepartamento=" + iddepartamento + ", nombre=" + nombre + "]";
	}

	public Integer getIddepartamento() {
		return iddepartamento;
	}

	public void setIddepartamento(Integer iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
