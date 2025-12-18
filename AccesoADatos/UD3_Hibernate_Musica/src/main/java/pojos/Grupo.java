package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupo")
public class Grupo implements Serializable{
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	
	private String nombre;
	private Date fecha;
	private String pais;
	
	// Grupo - Disco (1-N)
	@OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY)
	private List<Disco> discos = new ArrayList<Disco>();
	
	// Grupo - Club (1-N)
	@OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY)
	private List<Club> clubes = new ArrayList<Club>();
	
	// Grupo - Artista (N-N)
	@ManyToMany
	@JoinTable(
			joinColumns = {
					@JoinColumn (name = "cod", referencedColumnName = "cod")
			},
			inverseJoinColumns = {
					@JoinColumn (name = "dni", referencedColumnName = "dni")
			}
			)
	private List<Artista> artistas = new ArrayList<Artista>();
}
