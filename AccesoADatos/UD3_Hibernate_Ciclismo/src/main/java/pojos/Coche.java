package pojos;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="coche")
public class Coche implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cod;
	private Integer km;
	private String matricula;
	private String patrocinador;
	private String marca;
	private String funcion;
	private String tipo;
	
	// Coche - Equipo (1-1)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nomequipo")
	private Equipo equipo;

	public Coche() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coche(Integer cod, Integer km, String matricula, String patrocinador, String marca, String funcion,
			String tipo, Equipo equipo) {
		super();
		this.cod = cod;
		this.km = km;
		this.matricula = matricula;
		this.patrocinador = patrocinador;
		this.marca = marca;
		this.funcion = funcion;
		this.tipo = tipo;
		this.equipo = equipo;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public Integer getKm() {
		return km;
	}

	public void setKm(Integer km) {
		this.km = km;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getPatrocinador() {
		return patrocinador;
	}

	public void setPatrocinador(String patrocinador) {
		this.patrocinador = patrocinador;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod, equipo, funcion, km, marca, matricula, patrocinador, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return Objects.equals(cod, other.cod) && Objects.equals(equipo, other.equipo)
				&& Objects.equals(funcion, other.funcion) && Objects.equals(km, other.km)
				&& Objects.equals(marca, other.marca) && Objects.equals(matricula, other.matricula)
				&& Objects.equals(patrocinador, other.patrocinador) && Objects.equals(tipo, other.tipo);
	}
	
	
}
