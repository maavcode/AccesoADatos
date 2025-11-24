package pojos;

import java.util.Date;
import java.util.Objects;

public class Presentan implements Comparable<Presentan> {
    private Integer codAl;       // clave compuesta: alumno
    private String codP;         // clave compuesta: práctica
    private Integer nota;
    private Date fechaEntrega;

    // Constructor vacío
    public Presentan() {}

    // Constructor con parámetros
    public Presentan(Integer codAl, String codP, Integer nota, Date fechaEntrega) {
        this.codAl = codAl;
        this.codP = codP;
        this.nota = nota;
        this.fechaEntrega = fechaEntrega;
    }

    // Getters y Setters
    public Integer getCodAl() { return codAl; }
    public void setCodAl(Integer codAl) { this.codAl = codAl; }

    public String getCodP() { return codP; }
    public void setCodP(String codP) { this.codP = codP; }

    public Integer getNota() { return nota; }
    public void setNota(Integer nota) { this.nota = nota; }

    public Date getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(Date fechaEntrega) { this.fechaEntrega = fechaEntrega; }

    // toString
    @Override
    public String toString() {
        return "Presentan{" +
                "codAl=" + codAl +
                ", codP='" + codP + '\'' +
                ", nota=" + nota +
                ", fechaEntrega=" + fechaEntrega +
                '}';
    }

    // equals (clave compuesta: codAl + codP)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Presentan)) return false;
        Presentan that = (Presentan) o;
        return Objects.equals(codAl, that.codAl) &&
               Objects.equals(codP, that.codP);
    }

    // hashCode (coherente con equals)
    @Override
    public int hashCode() {
        return Objects.hash(codAl, codP);
    }

    // compareTo (primero por codAl, luego por codP)
    @Override
    public int compareTo(Presentan other) {
        int cmp = this.codAl.compareTo(other.codAl);
        if (cmp != 0) return cmp;
        return this.codP.compareTo(other.codP);
    }
}
