package pojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "puerto")
public class Puerto implements Serializable{
	@Id
	private String nompuerto;
	private Integer altura;
	private String categoria;
	private Double pendiente;
	
	// Puerto - Etapa (N-1)
	@ManyToOne(fetch = FetchType.LAZY) // TIENE LA CLAVE AJENA NETAPA
	@JoinColumn(name = "netapa")
	private Etapa etapa;
	
	// Puerto - Ciclista (N-1)
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "dorsal")
	private Ciclista ciclista;
	
}
