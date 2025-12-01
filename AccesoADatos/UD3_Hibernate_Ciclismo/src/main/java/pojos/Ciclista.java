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
	@OneToMany(mappedBy = "puerto", fetch = FetchType.LAZY) // mappedBy tiene que coincidir con la propiedad en la otra parte
	private List<Puerto> puertos = new ArrayList<Puerto>();
	
	
	// CAMPOS AUTO GENERADOS
	
}
