package pojos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="premios")
public class Premios {
	@Id
	private Integer codigo;
	private String descripcion;
	private Integer cantidad;
}
