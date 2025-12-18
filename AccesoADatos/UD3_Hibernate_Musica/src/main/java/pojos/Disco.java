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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "disco")
public class Disco implements Serializable{
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	
	private String nombre;
	private Date fecha;
	
	// Disco - Companyia (N-1)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_comp")
	private Companyia companyia;
	
	// Disco - Grupo (N-1)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_gru")
	private Grupo grupo;
	
	// Disco - Cancion (N-N)
	@ManyToMany(mappedBy = "discos")
	private List<Cancion> canciones = new ArrayList<Cancion>();
}
