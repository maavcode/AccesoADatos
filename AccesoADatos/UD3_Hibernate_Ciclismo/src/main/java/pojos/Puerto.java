package pojos;

import java.io.Serializable;
import java.util.Objects;

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
	

	public Puerto(String nompuerto, Integer altura, String categoria, Double pendiente, Etapa etapa,Ciclista ciclista) {
		super();
		this.nompuerto = nompuerto;
		this.altura = altura;
		this.categoria = categoria;
		this.pendiente = pendiente;
		this.etapa = etapa;
		this.ciclista = ciclista;
	}

	public Puerto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNompuerto() {
		return nompuerto;
	}

	public void setNompuerto(String nompuerto) {
		this.nompuerto = nompuerto;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getPendiente() {
		return pendiente;
	}

	public void setPendiente(Double pendiente) {
		this.pendiente = pendiente;
	}

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	public Ciclista getCiclista() {
		return ciclista;
	}

	public void setCiclista(Ciclista ciclista) {
		this.ciclista = ciclista;
	}

	@Override
	public String toString() {
		return "Puerto [nompuerto=" + nompuerto + ", altura=" + altura + ", categoria=" + categoria + ", pendiente="
				+ pendiente + ", etapa=" + etapa + ", ciclista=" + ciclista + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(altura, categoria, ciclista, etapa, nompuerto, pendiente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Puerto other = (Puerto) obj;
		return Objects.equals(altura, other.altura) && Objects.equals(categoria, other.categoria)
				&& Objects.equals(ciclista, other.ciclista) && Objects.equals(etapa, other.etapa)
				&& Objects.equals(nompuerto, other.nompuerto) && Objects.equals(pendiente, other.pendiente);
	}
	
	//
	
	
}
