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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // NECESARIO PARA HIBERNATE
@Table (name = "ciclista") // PARA QUE HIBERNATE ENCUENTRE LA TABLA
public class Ciclista implements Serializable{ // Para que el POJO sea serializable
	// ATRIBUTOS DE LA TABLA
	@Id // Dorsal es id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // Dorsal es autoincremental
	private Integer dorsal;
	private String nombre;
	private Date nacimiento;
	
	// Ciclista - Equipo (N-1)
	@ManyToOne(fetch = FetchType.LAZY) 
	// nomeq es una clave ajena (n,1)
	// GUARDA TAMBIEN EL METODO FETCH, EN ESTE CASO CREARA SOLO LAS LISTAS QUE USARAS
	@JoinColumn(name="nomeq") // nombre de la clave ajena
	private Equipo equipo; // AQUI SE GUARDA EL EQUIPO DEL CICLISTA
	
	// Ciclista - Etapa (1-N)
	@OneToMany(mappedBy = "ciclista", fetch = FetchType.LAZY ) // Un ciclista puede ganar muchas etapas
	private List<Etapa> etapas = new ArrayList<Etapa>(); // Aqui se guardan las etapas ganadas por el ciclista
	
	// Ciclista - Puerto (1-N)
	@OneToMany(mappedBy = "ciclista", fetch = FetchType.LAZY) // mappedBy tiene que coincidir con la propiedad en la otra parte
	private List<Puerto> puertos = new ArrayList<Puerto>();
	
	// Ciclista - Premios (N-N)
	@ManyToMany (mappedBy ="ciclistas") 
	// Solo Uno tiene @JoinColumn, los 2 tienen LISTAS
	private List<Premios> premios = new ArrayList<>();

	public Ciclista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ciclista(Integer dorsal, String nombre, Date nacimiento, Equipo equipo, List<Etapa> etapas,
			List<Puerto> puertos, List<Premios> premios) {
		super();
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.equipo = equipo;
		this.etapas = etapas;
		this.puertos = puertos;
		this.premios = premios;
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

	public List<Etapa> getEtapas() {
		return etapas;
	}

	public void setEtapas(List<Etapa> etapas) {
		this.etapas = etapas;
	}

	public List<Puerto> getPuertos() {
		return puertos;
	}

	public void setPuertos(List<Puerto> puertos) {
		this.puertos = puertos;
	}

	public List<Premios> getPremios() {
		return premios;
	}

	public void setPremios(List<Premios> premios) {
		this.premios = premios;
	}
	
	// CAMPOS AUTO GENERADOS
	
}
