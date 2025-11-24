import java.util.List;

public class Plato {
	private String nombre;
	private String tipo;
	private List<Ingrediente> ingredientes;

	public Plato(String nombre, String tipo, List<Ingrediente> ingredientes) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.ingredientes = ingredientes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public String toString() {
		return "Plato{" + "nombre='" + nombre + '\'' + ", tipo='" + tipo + '\'' + ", ingredientes=" + ingredientes
				+ '}';
	}

}