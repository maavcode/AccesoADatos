package pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jugadores")
public class Jugadores {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String nombre;
	private String altura;
	private String posicion;
	private String nacimiento;
	
	// Many to One
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "Nombre_equipo")
	private Equipos equipos_jugadores;
	
	
	public Jugadores() {}

	public Jugadores(String nombre, String altura, String posicion, String nacimiento,
			Equipos equipos_jugadores) {
		super();
		this.nombre = nombre;
		this.altura = altura;
		this.posicion = posicion;
		this.nacimiento = nacimiento;
		this.equipos_jugadores = equipos_jugadores;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public Equipos getEquipos_jugadores() {
		return equipos_jugadores;
	}

	public void setEquipos_jugadores(Equipos equipos_jugadores) {
		this.equipos_jugadores = equipos_jugadores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((altura == null) ? 0 : altura.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((equipos_jugadores == null) ? 0 : equipos_jugadores.hashCode());
		result = prime * result + ((nacimiento == null) ? 0 : nacimiento.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Jugadores))
			return false;
		Jugadores other = (Jugadores) obj;
		if (altura == null) {
			if (other.altura != null)
				return false;
		} else if (!altura.equals(other.altura))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (equipos_jugadores == null) {
			if (other.equipos_jugadores != null)
				return false;
		} else if (!equipos_jugadores.equals(other.equipos_jugadores))
			return false;
		if (nacimiento == null) {
			if (other.nacimiento != null)
				return false;
		} else if (!nacimiento.equals(other.nacimiento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}


}
