package pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "club")
public class Club implements Serializable{
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	
	private String nombre;
	private String sede;
	private Integer num;
	
	// Club - Grupo (N-1)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_gru")
	private Grupo grupo;
}

