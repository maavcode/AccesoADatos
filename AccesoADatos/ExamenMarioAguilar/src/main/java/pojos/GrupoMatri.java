package pojos;



import java.util.Objects;

public class GrupoMatri implements Comparable<GrupoMatri> {
    private String codG;
    private Integer codAl;
    private String codH;

    public GrupoMatri() {}

    public GrupoMatri(String codG, Integer codAl, String codH) {
        this.codG = codG;
        this.codAl = codAl;
        this.codH = codH;
    }

    public String getCodG() { return codG; }
    public void setCodG(String codG) { this.codG = codG; }

    public Integer getCodAl() { return codAl; }
    public void setCodAl(Integer codAl) { this.codAl = codAl; }

    public String getCodH() { return codH; }
    public void setCodH(String codH) { this.codH = codH; }

    @Override
    public String toString() {
        return "GrupoMatri{" + "codG='" + codG + '\'' + ", codAl=" + codAl + ", codH='" + codH + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GrupoMatri)) return false;
        GrupoMatri that = (GrupoMatri) o;
        return Objects.equals(codG, that.codG) && Objects.equals(codAl, that.codAl);
    }

    @Override
    public int hashCode() { return Objects.hash(codG, codAl); }

    @Override
    public int compareTo(GrupoMatri other) {
        int cmp = this.codG.compareTo(other.codG);
        if (cmp != 0) return cmp;
        return this.codAl.compareTo(other.codAl);
    }
}
