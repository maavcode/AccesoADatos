package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // NECESARIO PARA HIBERNATE
@Table (name = "ciclista") // PARA QUE HIBERNATE ENCUENTRE LA TABLA
public class Ciclista implements Serializable{ // Para que el POJO sea serializable
	// ATRIBUTOS DE LA TABLA
	@Id // Dorsal es id
	@GeneratedValue(strategy=GenerationType.AUTO) // Dorsal es autoincremental
	private Integer dorsal;
	private String nombre;
	private Date nacimiento;
	// CLAVES AJENAS
	@ManyToOne(fetch = FetchType.LAZY) 
	// nomeq es una clave ajena (n,1)
	// GUARDA TAMBIEN EL METODO FETCH, EN ESTE CASO CREARA SOLO LAS LISTAS QUE USARAS
	@JoinColumn(name="nomeq") // nombre de la clave ajena
	private Equipo equipo; // AQUI SE GUARDA EL EQUIPO DEL CICLISTA
	
	@OneToMany(mappedBy = "ciclista", fetch = FetchType.LAZY ) // Un ciclista puede ganar muchas etapas
	private List<Etapa> etapas = new ArrayList<Etapa>(); // Aqui se guardan las etapas ganadas por el ciclista
	
	
	// CAMPOS AUTO GENERADOS
	public Ciclista() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Ciclista(Integer dorsal, String nombre, Date nacimiento, Equipo equipo) {
		super();
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.equipo = equipo;
	}



	public Integer getDorsal() {
		return dorsal;
	}



	public void setDorsal(Integer dorsal) {
		this.dorsal = dorsal;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Date getNacimiento() {
		return nacimiento;
	}



	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}



	public Equipo getEquipo() {
		return equipo;
	}



	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}



	@Override
	public int hashCode() {
		return Objects.hash(dorsal, nacimiento, nombre);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciclista other = (Ciclista) obj;
		return Objects.equals(dorsal, other.dorsal) && Objects.equals(nacimiento, other.nacimiento)
				&& Objects.equals(nombre, other.nombre);
	}



	@Override
	public String toString() {
		return "Ciclista [dorsal=" + dorsal + ", nombre=" + nombre + ", nacimiento=" + nacimiento + "]";
	}
	
	
}
