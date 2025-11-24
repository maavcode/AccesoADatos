package pojos;



import java.util.Objects;

public class Alumno implements Comparable<Alumno> {
    private Integer codA;
    private String nombre;
    private String domicilio;

    public Alumno() {}

    public Alumno(Integer codA, String nombre, String domicilio) {
        this.codA = codA;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public Integer getCodA() { return codA; }
    public void setCodA(Integer codA) { this.codA = codA; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDomicilio() { return domicilio; }
    public void setDomicilio(String domicilio) { this.domicilio = domicilio; }

    @Override
    public String toString() {
        return "Alumno{" + "codA=" + codA + ", nombre='" + nombre + '\'' + ", domicilio='" + domicilio + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(codA, alumno.codA);
    }

    @Override
    public int hashCode() { return Objects.hash(codA); }

    @Override
    public int compareTo(Alumno other) {
        return this.codA.compareTo(other.codA);
    }
}
