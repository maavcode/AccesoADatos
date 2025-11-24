package pojos;

import java.util.Objects;

public class Grupo implements Comparable<Grupo> {
	private String codG;
	private String codAsig;
	private String codH;

	public Grupo() {
	}

	public Grupo(String codG, String codAsig, String codH) {
		this.codG = codG;
		this.codAsig = codAsig;
		this.codH = codH;
	}

	public String getCodG() {
		return codG;
	}

	public void setCodG(String codG) {
		this.codG = codG;
	}

	public String getCodAsig() {
		return codAsig;
	}

	public void setCodAsig(String codAsig) {
		this.codAsig = codAsig;
	}

	public String getCodH() {
		return codH;
	}

	public void setCodH(String codH) {
		this.codH = codH;
	}

	@Override
	public String toString() {
		return "Grupo{" + "codG='" + codG + '\'' + ", codAsig='" + codAsig + '\'' + ", codH='" + codH + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Grupo))
			return false;
		Grupo grupo = (Grupo) o;
		return Objects.equals(codG, grupo.codG);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codG);
	}

	@Override
	public int compareTo(Grupo other) {
		return this.codG.compareTo(other.codG);
	}
}
