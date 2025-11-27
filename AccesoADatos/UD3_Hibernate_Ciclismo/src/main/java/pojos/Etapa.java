package pojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="etapa")
public class Etapa implements Serializable{
	@Id
	private Integer netapa;
	private Integer km;
	private String salida;
	private String llegada;
	
	@ManyToOne(fetch = FetchType.LAZY) // Una etapa puede ser ganada solo por un ciclista
	@JoinColumn(name="dorsal") // Clave ajena que conecta el la etapa con el ciclista
	private Ciclista ciclista;
	
	
}
