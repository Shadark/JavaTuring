package check;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import def.MT;
import def.Simbolo;
import parse.ParseMT;

public class MainCheck {
	
	public static final File fileMT = new File("turing/anbncn.txt");

	public static void main(String[] args) {
		//Cargamos MT en txt
		MT test = ParseMT.parseMt(fileMT);
		System.out.println("Introduzca la cadena a comprobar:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cadena = null;
		try {
			cadena = br.readLine();
		} catch (IOException ioe) {
			System.out.println("Error leyendo cadena.");
			System.exit(1);
		}
		System.out.println("Cadena aceptada: " + test.prodMt(cadena));
		System.out.print("Cinta final: ");
		for (Simbolo s : test.getCinta())
			if (!s.equals(Simbolo.BLANCO))
				System.out.print(s);
		System.out.println();
	}

}