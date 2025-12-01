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
}
