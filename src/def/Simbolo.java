package def;

public class Simbolo {
	
	private String simbolo;
	
	public Simbolo (String simbolo) {
		this.simbolo = simbolo;
	}

	public static final Simbolo BLANCO = new Simbolo("_");
	
	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((simbolo == null) ? 0 : simbolo.hashCode());
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
		Simbolo other = (Simbolo) obj;
		if (simbolo == null) {
			if (other.simbolo != null)
				return false;
		} else if (!simbolo.equals(other.simbolo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return simbolo;
	}
	
}
