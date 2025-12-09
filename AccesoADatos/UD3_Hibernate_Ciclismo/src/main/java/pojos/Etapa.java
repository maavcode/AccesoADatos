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

	public Etapa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etapa(Integer netapa, Integer km, String salida, String llegada, Ciclista ciclista, List<Puerto> puertos) {
		super();
		this.netapa = netapa;
		this.km = km;
		this.salida = salida;
		this.llegada = llegada;
		this.ciclista = ciclista;
		this.puertos = puertos;
	}

	public Integer getNetapa() {
		return netapa;
	}

	public void setNetapa(Integer netapa) {
		this.netapa = netapa;
	}

	public Integer getKm() {
		return km;
	}

	public void setKm(Integer km) {
		this.km = km;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public String getLlegada() {
		return llegada;
	}

	public void setLlegada(String llegada) {
		this.llegada = llegada;
	}

	public Ciclista getCiclista() {
		return ciclista;
	}

	public void setCiclista(Ciclista ciclista) {
		this.ciclista = ciclista;
	}

	public List<Puerto> getPuertos() {
		return puertos;
	}

	public void setPuertos(List<Puerto> puertos) {
		this.puertos = puertos;
	}
	
	

}
