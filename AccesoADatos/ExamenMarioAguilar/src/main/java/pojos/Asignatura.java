package pojos;



import java.util.Objects;

public class Asignatura implements Comparable<Asignatura> {
    private String codAsig;
    private String descripcion;
    private String ciclo;

    public Asignatura() {}

    public Asignatura(String codAsig, String descripcion, String ciclo) {
        this.codAsig = codAsig;
        this.descripcion = descripcion;
        this.ciclo = ciclo;
    }

    public String getCodAsig() { return codAsig; }
    public void setCodAsig(String codAsig) { this.codAsig = codAsig; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getCiclo() { return ciclo; }
    public void setCiclo(String ciclo) { this.ciclo = ciclo; }

    @Override
    public String toString() {
        return "Asignatura{" + "codAsig='" + codAsig + '\'' + ", descripcion='" + descripcion + '\'' + ", ciclo='" + ciclo + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asignatura)) return false;
        Asignatura that = (Asignatura) o;
        return Objects.equals(codAsig, that.codAsig);
    }

    @Override
    public int hashCode() { return Objects.hash(codAsig); }

    @Override
    public int compareTo(Asignatura other) {
        return this.codAsig.compareTo(other.codAsig);
    }
}
