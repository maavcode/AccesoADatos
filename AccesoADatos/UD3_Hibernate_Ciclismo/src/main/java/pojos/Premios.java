package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="premios")
public class Premios {
	@Id
	private Integer codigo;
	private String descripcion;
	private Integer cantidad;
	
	// Premios - Ciclista (N-N)
	@ManyToMany 
	@JoinTable( // Referenciamos una tabla intermedia y especificamos lo que tiene. 
			name="gana", // La tabla se llama gana
			joinColumns= {
					@JoinColumn (name="premio",referencedColumnName="codigo") // Tiene una propiedad premio que referencia a codigo
					},
			inverseJoinColumns= {
					@JoinColumn (name="dorsal",referencedColumnName="dorsal") // Tiene una propiedad dorsal que referencia a dorsal
					}
			) 
	private List<Ciclista> ciclistas=new ArrayList<Ciclista>();

}
