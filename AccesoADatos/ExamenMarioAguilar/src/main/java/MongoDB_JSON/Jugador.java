package MongoDB_JSON;

import java.util.List;
import java.util.Objects;

public class Jugador {
	private String nombre;
	private String genero;
	private List <String> hobby;
	public Jugador(String nombre, String genero, List<String> hobby) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.hobby = hobby;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public List<String> getHobby() {
		return hobby;
	}
	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}
	@Override
	public int hashCode() {
		return Objects.hash(genero, hobby, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(genero, other.genero) && Objects.equals(hobby, other.hobby)
				&& Objects.equals(nombre, other.nombre);
	}
	
}
