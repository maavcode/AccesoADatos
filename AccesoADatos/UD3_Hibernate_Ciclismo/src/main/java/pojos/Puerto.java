package pojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Puerto implements Serializable{
	@Id
	private String nompuerto;
	private Integer altura;
	private String categoria;
	private Double pendiente;
	
	@ManyToOne
}
