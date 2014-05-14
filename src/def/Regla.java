package def;

public class Regla {

	private Estado estIni;
	private Simbolo simIni;
	private Estado estFin;
	private Simbolo simFin;
	private Accion accion;

	public Regla(Estado estIni, Simbolo simIni, Estado estFin, Simbolo simFin,
			Accion accion) {
		this.estIni = estIni;
		this.simIni = simIni;
		this.estFin = estFin;
		this.simFin = simFin;
		this.accion = accion;
	}

	public Estado getEstIni() {
		return estIni;
	}

	public void setEstIni(Estado estIni) {
		this.estIni = estIni;
	}

	public Simbolo getSimIni() {
		return simIni;
	}

	public void setSimIni(Simbolo simIni) {
		this.simIni = simIni;
	}

	public Estado getEstFin() {
		return estFin;
	}

	public void setEstFin(Estado estFin) {
		this.estFin = estFin;
	}

	public Simbolo getSimFin() {
		return simFin;
	}

	public void setSimFin(Simbolo simFin) {
		this.simFin = simFin;
	}

	public Accion getAccion() {
		return accion;
	}

	public void setAccion(Accion accion) {
		this.accion = accion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accion == null) ? 0 : accion.hashCode());
		result = prime * result + ((estFin == null) ? 0 : estFin.hashCode());
		result = prime * result + ((estIni == null) ? 0 : estIni.hashCode());
		result = prime * result + ((simFin == null) ? 0 : simFin.hashCode());
		result = prime * result + ((simIni == null) ? 0 : simIni.hashCode());
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
		Regla other = (Regla) obj;
		if (accion != other.accion)
			return false;
		if (estFin == null) {
			if (other.estFin != null)
				return false;
		} else if (!estFin.equals(other.estFin))
			return false;
		if (estIni == null) {
			if (other.estIni != null)
				return false;
		} else if (!estIni.equals(other.estIni))
			return false;
		if (simFin == null) {
			if (other.simFin != null)
				return false;
		} else if (!simFin.equals(other.simFin))
			return false;
		if (simIni == null) {
			if (other.simIni != null)
				return false;
		} else if (!simIni.equals(other.simIni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + estIni + ", " + simIni + ") -> (" + estFin + ", " + simFin
				+ ", " + accion + ")";
	}

}
