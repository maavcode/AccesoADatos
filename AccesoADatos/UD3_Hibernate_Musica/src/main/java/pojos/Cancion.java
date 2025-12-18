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
@Table(name = "cancion")
public class Cancion implements Serializable{
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	
	private String titulo;
	private Double duracion;
	
	// Cancion - Disco (N-N)
	@ManyToMany
	@JoinTable(
			name = "esta",
			joinColumns = {
					@JoinColumn (name="can",referencedColumnName = "cod")
			},
			inverseJoinColumns = {
					@JoinColumn (name="cod",referencedColumnName = "cod")
			}
			)
	private List<Disco> discos = new ArrayList<Disco>();
}
