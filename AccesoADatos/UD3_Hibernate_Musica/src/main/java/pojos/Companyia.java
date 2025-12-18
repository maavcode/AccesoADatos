package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "companyia")
public class Companyia implements Serializable {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	
	private String nombre;
	private String dir;
	private String fax;
	private String tfno;
	
	// Companyia - Disco (1-N)
	@OneToMany(mappedBy = "companyia", fetch = FetchType.LAZY)
	private List<Disco> discos = new ArrayList<Disco>();

}
