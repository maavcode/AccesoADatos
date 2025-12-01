package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="etapa")
public class Etapa implements Serializable{
	@Id
	private Integer netapa;
	private Integer km;
	private String salida;
	private String llegada;
	
	// Etapa - Ciclista (1-N)
	@ManyToOne(fetch = FetchType.LAZY) // Una etapa puede ser ganada solo por un ciclista
	@JoinColumn(name="dorsal") // Clave ajena que conecta el la etapa con el ciclista
	private Ciclista ciclista;
	
	// Etapa - Puerto (1-N)
	@OneToMany(mappedBy = "etapa", fetch = FetchType.LAZY)
	private List<Puerto> puertos = new ArrayList<Puerto>();

}
