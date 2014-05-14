package def;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MT {

	private Set<Estado> listaEstados;
	private Estado estado;
	private Set<Estado> finales;
	private Set<Regla> delta;
	private List<Simbolo> cinta;
	private int cabeza;

	private boolean traza = false;

	public MT(Set<Estado> estados, Estado estado, Set<Estado> finales,
			Set<Regla> delta) {
		this.listaEstados = estados;
		this.estado = estado;
		this.finales = finales;
		this.delta = delta;
		cinta = new LinkedList<Simbolo>();
		//Ya que siempre insertaremos un blanco al principio y al final,
		//empezamos en la primera posición (posición inicial de la cadena)
		cabeza = 1;
	}

	public Set<Estado> getEstados() {
		return listaEstados;
	}

	public void setEstados(Set<Estado> estados) {
		this.listaEstados = estados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Set<Estado> getFinales() {
		return finales;
	}

	public void setFinales(Set<Estado> finales) {
		this.finales = finales;
	}

	public Set<Regla> getDelta() {
		return delta;
	}

	public void setDelta(Set<Regla> delta) {
		this.delta = delta;
	}

	public List<Simbolo> getCinta() {
		return cinta;
	}

	public void setCinta(List<Simbolo> cinta) {
		this.cinta = cinta;
	}

	private List<Regla> getProds(Estado estado, Simbolo simbolo) {
		List<Regla> prods = new LinkedList<Regla>();
		for (Regla r : delta)
			if (r.getEstIni().equals(estado) && r.getSimIni().equals(simbolo))
				prods.add(r);
		return prods;
	}

	/* 
	 * Imprime el estado actual de la MT
	 */
	
	private void imprimirMt() {
		for (int i = 0; i < cinta.size(); i++) {
			if (i == cabeza)
				System.out.print(" #" + estado + "# ");
			if (!cinta.get(i).equals(Simbolo.BLANCO))
				System.out.print(" " + cinta.get(i) + " ");
		}
		System.out.println();
	}

	/*
	 * Avanza la cabeza de la MT según la regla r
	 */
	
	private void avanzarCabeza(Regla r) {
		cinta.set(cabeza, r.getSimFin());
		estado = r.getEstFin();
		switch (r.getAccion()) {
			case R:
				cabeza++;
				if (cabeza == cinta.size())
					cinta.add(Simbolo.BLANCO);
				break;
			case L:
				cabeza--;
				if (cabeza < 0)
					cinta.add(0, Simbolo.BLANCO);
				break;
			case N:
				break;
		}
		if (traza)
			imprimirMt();
	}
	
	/*
	 * Genera las producciones de la MT según una cadena de entrada.
	 */

	public String prodMt(String cintaIni) {

		
		//Añadimos un blanco al principio y al final de la cadena
		cinta.add(Simbolo.BLANCO);
		String[] simbolos = cintaIni.split("(?!^)");
		for (String s : simbolos)
			if ((!s.equals("")) && (!s.equals(" ")))
				cinta.add(new Simbolo(s));
		cinta.add(Simbolo.BLANCO);

		if (traza)
			imprimirMt();

		//Generamos la lista de posibles producciones
		List<Regla> reglas = getProds(estado, cinta.get(cabeza));
		
		while (!finales.contains(estado) && !reglas.isEmpty()) {
			for (Regla r: reglas)
				avanzarCabeza(r);
			reglas = getProds(estado, cinta.get(cabeza));
		}

		StringBuilder cintaFin = new StringBuilder();
		for (Simbolo s : cinta)
			if (!s.equals(Simbolo.BLANCO))
				cintaFin.append(s.toString());
		return new String(cintaFin);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((delta == null) ? 0 : delta.hashCode());
		result = prime * result
				+ ((listaEstados == null) ? 0 : listaEstados.hashCode());
		result = prime * result + ((finales == null) ? 0 : finales.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
		MT other = (MT) obj;
		if (delta == null) {
			if (other.delta != null)
				return false;
		} else if (!delta.equals(other.delta))
			return false;
		if (listaEstados == null) {
			if (other.listaEstados != null)
				return false;
		} else if (!listaEstados.equals(other.listaEstados))
			return false;
		if (finales == null) {
			if (other.finales != null)
				return false;
		} else if (!finales.equals(other.finales))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MT [listaEstados=" + listaEstados + ", estado=" + estado
				+ ", finales=" + finales + ", delta=" + delta + "]";
	}

}
