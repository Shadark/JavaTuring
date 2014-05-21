package def;

import java.util.List;

public class MTConfig {

	private Estado estado;
	private List<Simbolo> cinta;
	private Regla regla;
	private int cabeza;

	public MTConfig (Estado estado, List<Simbolo> cinta, Regla regla, int cabeza) {
		this.estado = estado;
		this.cinta = cinta;
		this.regla = regla;
		this.cabeza = cabeza;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Simbolo> getCinta() {
		return cinta;
	}

	public void setCinta(List<Simbolo> cinta) {
		this.cinta = cinta;
	}

	public Regla getRegla() {
		return regla;
	}

	public void setRegla(Regla regla) {
		this.regla = regla;
	}

	public int getCabeza() {
		return cabeza;
	}

	public void setCabeza(int cabeza) {
		this.cabeza = cabeza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cabeza;
		result = prime * result + ((cinta == null) ? 0 : cinta.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((regla == null) ? 0 : regla.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MTConfig other = (MTConfig) obj;
		if (cabeza != other.cabeza)
			return false;
		if (cinta == null) {
			if (other.cinta != null)
				return false;
		} else if (!cinta.equals(other.cinta))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (regla == null) {
			if (other.regla != null)
				return false;
		} else if (!regla.equals(other.regla))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MTConfig [estado=" + estado + ", cinta=" + cinta + ", regla="
				+ regla + ", cabeza=" + cabeza + "]";
	}
	
}
