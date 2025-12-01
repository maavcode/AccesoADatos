package pojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="representante")
public class Representante implements Serializable {
	@Id
	private Integer id;
	private String nombre;
	
	// Representante - Equipo (1-1)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nom_eq")
	private Equipo equipo;
}
