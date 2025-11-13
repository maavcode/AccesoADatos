package pojos;

public class Usuario {
	private Integer idUsuario;
	private String userName;
	private String password;
	private Integer tipo;
	private Integer rol;
	private String grupo;
	private Integer departamento;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String domicilio;
	private String poblacion;
	private String codPostal;
	private String email;
	private String telefono;
	
	public Usuario(){}
	
	

	public Usuario(Integer idUsuario, String userName, String password, Integer tipo, Integer rol, String grupo,
			Integer departamento, String nombre, String apellido1, String apellido2, String domicilio, String poblacion,
			String codPostal, String email, String telefono) {
		super();
		this.idUsuario = idUsuario;
		this.userName = userName;
		this.password = password;
		this.tipo = tipo;
		this.rol = rol;
		this.grupo = grupo;
		this.departamento = departamento;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.domicilio = domicilio;
		this.poblacion = poblacion;
		this.codPostal = codPostal;
		this.email = email;
		this.telefono = telefono;
	}



	public Integer getIdUsuario() {
		return idUsuario;
	}
	

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getRol() {
		return rol;
	}

	public void setRol(Integer rol) {
		this.rol = rol;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Integer getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Integer departamento) {
		this.departamento = departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
}

