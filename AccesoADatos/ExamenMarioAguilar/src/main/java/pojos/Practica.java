package pojos;


import java.util.Date;
import java.util.Objects;

public class Practica implements Comparable<Practica> {
    private String codP;
    private Integer puntos;
    private Integer curso;
    private Date fechaLimite;

    public Practica() {}

    public Practica(String codP, Integer puntos, Integer curso, Date fechaLimite) {
        this.codP = codP;
        this.puntos = puntos;
        this.curso = curso;
        this.fechaLimite = fechaLimite;
    }

    public String getCodP() { return codP; }
    public void setCodP(String codP) { this.codP = codP; }

    public Integer getPuntos() { return puntos; }
    public void setPuntos(Integer puntos) { this.puntos = puntos; }

    public Integer getCurso() { return curso; }
    public void setCurso(Integer curso) { this.curso = curso; }

    public Date getFechaLimite() { return fechaLimite; }
    public void setFechaLimite(Date fechaLimite) { this.fechaLimite = fechaLimite; }

    @Override
    public String toString() {
        return "Practica{" + "codP='" + codP + '\'' + ", puntos=" + puntos + ", curso=" + curso + ", fechaLimite=" + fechaLimite + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Practica)) return false;
        Practica practica = (Practica) o;
        return Objects.equals(codP, practica.codP);
    }

    @Override
    public int hashCode() { return Objects.hash(codP); }

    @Override
    public int compareTo(Practica other) {
        return this.codP.compareTo(other.codP);
    }
}
