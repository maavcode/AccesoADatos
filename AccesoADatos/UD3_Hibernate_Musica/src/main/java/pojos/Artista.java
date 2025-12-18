package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "artista")
public class Artista implements Serializable{
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dni;
	
	private String nombre;
	
	// Artista - Grupo (N-N)
	@ManyToMany
	@JoinTable(
			joinColumns = {
					@JoinColumn (name = "dni", referencedColumnName = "dni")
			},
			inverseJoinColumns = {
					@JoinColumn (name = "cod", referencedColumnName = "cod")
			}
			)
	private List<Grupo> grupos = new ArrayList<Grupo>();
}
