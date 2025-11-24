package pojos;

import java.util.Date;
import java.util.Objects;

public class Articulo {
	
	private Integer idArticulo;
	private String numserie;
	private String estado;
	private Date fechaalta;
	private Date fechabaja;
	private Integer usuarioalta;
	private Integer usuariobaja;
	private Integer modelo;
	private Integer departamento;
	private Integer espacio;
	private Integer dentrode;
	private String observaciones;
	public Integer getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}
	public String getNumserie() {
		return numserie;
	}
	public void setNumserie(String numserie) {
		this.numserie = numserie;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaalta() {
		return fechaalta;
	}
	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}
	public Date getFechabaja() {
		return fechabaja;
	}
	public void setFechabaja(Date fechabaja) {
		this.fechabaja = fechabaja;
	}
	public Integer getUsuarioalta() {
		return usuarioalta;
	}
	public void setUsuarioalta(Integer usuarioalta) {
		this.usuarioalta = usuarioalta;
	}
	public Integer getUsuariobaja() {
		return usuariobaja;
	}
	public void setUsuariobaja(Integer usuariobaja) {
		this.usuariobaja = usuariobaja;
	}
	public Integer getModelo() {
		return modelo;
	}
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}
	public Integer getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Integer departamento) {
		this.departamento = departamento;
	}
	public Integer getEspacio() {
		return espacio;
	}
	public void setEspacio(Integer espacio) {
		this.espacio = espacio;
	}
	public Integer getDentrode() {
		return dentrode;
	}
	public void setDentrode(Integer dentrode) {
		this.dentrode = dentrode;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dentrode, departamento, espacio, estado, fechaalta, fechabaja, idArticulo, modelo, numserie,
				observaciones, usuarioalta, usuariobaja);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		return Objects.equals(dentrode, other.dentrode) && Objects.equals(departamento, other.departamento)
				&& Objects.equals(espacio, other.espacio) && Objects.equals(estado, other.estado)
				&& Objects.equals(fechaalta, other.fechaalta) && Objects.equals(fechabaja, other.fechabaja)
				&& Objects.equals(idArticulo, other.idArticulo) && Objects.equals(modelo, other.modelo)
				&& Objects.equals(numserie, other.numserie) && Objects.equals(observaciones, other.observaciones)
				&& Objects.equals(usuarioalta, other.usuarioalta) && Objects.equals(usuariobaja, other.usuariobaja);
	}
	public Articulo(Integer idArticulo, String numserie, String estado, Date fechaalta, Date fechabaja,
			Integer usuarioalta, Integer usuariobaja, Integer modelo, Integer departamento, Integer espacio,
			Integer dentrode, String observaciones) {
		super();
		this.idArticulo = idArticulo;
		this.numserie = numserie;
		this.estado = estado;
		this.fechaalta = fechaalta;
		this.fechabaja = fechabaja;
		this.usuarioalta = usuarioalta;
		this.usuariobaja = usuariobaja;
		this.modelo = modelo;
		this.departamento = departamento;
		this.espacio = espacio;
		this.dentrode = dentrode;
		this.observaciones = observaciones;
	}
	public Articulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
