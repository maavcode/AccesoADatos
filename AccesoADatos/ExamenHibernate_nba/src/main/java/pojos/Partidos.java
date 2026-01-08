package pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "partidos")
public class Partidos {

	@Id
	private Integer codigo;
	private Integer puntos_local;
	private Integer puntos_visitante;
	private String temporada;
	@Column(name="fechahora")

	private String fecha_hora;
	
	//Many to One
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "equipo_visitante")
	private Equipos equipos_partidos_v;
	
	//Many to One
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "equipo_local")
	private Equipos equipos_partidos_l;
	
	// Many to Many
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "partidos_materialDeportivo")
	private List<MaterialDeportivo> materialDeportivo;
	
	public Partidos() {}

	public Partidos(Integer codigo, Integer puntos_local, Integer puntos_visitante, String temporada, String fecha_hora,
			Equipos equipos_partidos_v, Equipos equipos_partidos_l) {
		super();
		this.codigo = codigo;
		this.puntos_local = puntos_local;
		this.puntos_visitante = puntos_visitante;
		this.temporada = temporada;
		this.fecha_hora = fecha_hora;
		this.equipos_partidos_v = equipos_partidos_v;
		this.equipos_partidos_l = equipos_partidos_l;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getPuntos_local() {
		return puntos_local;
	}

	public void setPuntos_local(Integer puntos_local) {
		this.puntos_local = puntos_local;
	}

	public Integer getPuntos_visitante() {
		return puntos_visitante;
	}

	public void setPuntos_visitante(Integer puntos_visitante) {
		this.puntos_visitante = puntos_visitante;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public String getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(String fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public Equipos getEquipos_partidos_v() {
		return equipos_partidos_v;
	}

	public void setEquipos_partidos_v(Equipos equipos_partidos_v) {
		this.equipos_partidos_v = equipos_partidos_v;
	}

	public Equipos getEquipos_partidos_l() {
		return equipos_partidos_l;
	}

	public void setEquipos_partidos_l(Equipos equipos_partidos_l) {
		this.equipos_partidos_l = equipos_partidos_l;
	}

	public List<MaterialDeportivo> getMaterialDeportivo() {
		return materialDeportivo;
	}

	public void setMaterialDeportivo(List<MaterialDeportivo> materialDeportivo) {
		this.materialDeportivo = materialDeportivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((equipos_partidos_l == null) ? 0 : equipos_partidos_l.hashCode());
		result = prime * result + ((equipos_partidos_v == null) ? 0 : equipos_partidos_v.hashCode());
		result = prime * result + ((fecha_hora == null) ? 0 : fecha_hora.hashCode());
		result = prime * result + ((materialDeportivo == null) ? 0 : materialDeportivo.hashCode());
		result = prime * result + ((puntos_local == null) ? 0 : puntos_local.hashCode());
		result = prime * result + ((puntos_visitante == null) ? 0 : puntos_visitante.hashCode());
		result = prime * result + ((temporada == null) ? 0 : temporada.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Partidos))
			return false;
		Partidos other = (Partidos) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (equipos_partidos_l == null) {
			if (other.equipos_partidos_l != null)
				return false;
		} else if (!equipos_partidos_l.equals(other.equipos_partidos_l))
			return false;
		if (equipos_partidos_v == null) {
			if (other.equipos_partidos_v != null)
				return false;
		} else if (!equipos_partidos_v.equals(other.equipos_partidos_v))
			return false;
		if (fecha_hora == null) {
			if (other.fecha_hora != null)
				return false;
		} else if (!fecha_hora.equals(other.fecha_hora))
			return false;
		if (materialDeportivo == null) {
			if (other.materialDeportivo != null)
				return false;
		} else if (!materialDeportivo.equals(other.materialDeportivo))
			return false;
		if (puntos_local == null) {
			if (other.puntos_local != null)
				return false;
		} else if (!puntos_local.equals(other.puntos_local))
			return false;
		if (puntos_visitante == null) {
			if (other.puntos_visitante != null)
				return false;
		} else if (!puntos_visitante.equals(other.puntos_visitante))
			return false;
		if (temporada == null) {
			if (other.temporada != null)
				return false;
		} else if (!temporada.equals(other.temporada))
			return false;
		return true;
	}


}
