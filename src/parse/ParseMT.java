package parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import def.Accion;
import def.Estado;
import def.MT;
import def.Regla;
import def.Simbolo;

public class ParseMT {

	public ParseMT() {

	}

	public static MT parseMt(File file) {

		String delims = "[\\(,\\)\\-]+";
		
		Set<Estado> estados = new HashSet<Estado>();
		Estado inicial = null;
		Set<Estado> finales = new HashSet<Estado>();
		Set<Regla> delta = new HashSet<Regla>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			//Primera línea: estado inicial
			String[] ini = br.readLine().split("[\\(\\)]");
			for (String s : ini)
				if (!s.equals(""))
					inicial = new Estado(s);
			
			//Segunda línea: estados finales
			String[] fin = br.readLine().split("[\\(,\\)]");
			for (String s: fin)
				if (!s.equals(""))
					finales.add(new Estado(s));
			
			for (String line; (line = br.readLine()) != null;) {
				//Parseamos cada línea
				String[] tokens = line.split(delims);
				//Actualizamos los componentes de la MT
				Estado estIni = new Estado(tokens[1]);
				estados.add(estIni);
				Simbolo simIni = new Simbolo(tokens[2]);
				Estado estFin = new Estado(tokens[3]);
				estados.add(estFin);
				Simbolo simFin = new Simbolo(tokens[4]);
				Accion accion = Accion.valueOf(tokens[5]);
				Regla regla = new Regla(estIni, simIni, estFin, simFin, accion);
				delta.add(regla);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new MT(estados, inicial, finales, delta);
	}
}
