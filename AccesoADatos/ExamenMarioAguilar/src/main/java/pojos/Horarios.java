package pojos;
import java.util.Objects;

public class Horarios {
	    private String codH;     // Clase: String
	    private String horario;  // Clase: String

	    // Constructor sin parámetros
	    public Horarios() {
	    }

	

	    public Horarios(String codH, String horario) {
			super();
			this.codH = codH;
			this.horario = horario;
		}



		// Getters y Setters
	    public String getCodH() {
	        return codH;
	    }

	    public void setCodH(String codH) {
	        this.codH = codH;
	    }

	    public String getHorario() {
	        return horario;
	    }

	    public void setHorario(String horario) {
	        this.horario = horario;
	    }

	    // toString
	    @Override
	    public String toString() {
	        return "Horario{" +
	               "codH='" + codH + '\'' +
	               ", horario='" + horario + '\'' +
	               '}';
	    }

	    // equals (compara por ambos campos)
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Horarios)) return false;
	        Horarios that = (Horarios) o;
	        return Objects.equals(codH, that.codH) &&
	               Objects.equals(horario, that.horario);
	    }

	    // hashCode (coherente con equals)
	    @Override
	    public int hashCode() {
	        return Objects.hash(codH, horario);
	    }

	    // compareTo (ordena por codH; si es igual, por horario)
	    
	    public int compareTo(Horarios other) {
	        if (other == null) return 1;
	        int byCod = compareNullableStrings(this.codH, other.codH);
	        if (byCod != 0) return byCod;
	        return compareNullableStrings(this.horario, other.horario);
	    }

	    // Utilidad para comparar Strings que pueden ser null
	    private static int compareNullableStrings(String a, String b) {
	        if (a == b) return 0;
	        if (a == null) return -1;
	        if (b == null) return 1;
	        return a.compareTo(b);
	    }
	}



